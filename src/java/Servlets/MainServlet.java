package Servlets;

import Commands.Abstract.AbstractCommand;
import Factories.CommandFactory;
import Services.MessageService;
import Services.UserService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul Millar <D00152098>
 */
@WebServlet(loadOnStartup = 1, urlPatterns = {  "/views/main/category",
                                                "/views/main/product",
                                                "/views/main/service",
                                                "/views/main/user",
                                                "/views/admin/category",
                                                "/views/admin/product",
                                                "/views/admin/service",
                                                "/views/admin/user",
                                                "/views/admin/order",
                                                "/views/admin/orderitem"})

// NOTE:    We are using a generic DAO interface for CRUD operations on our DTO's.
//          This means that we have one insert command, one update command, one delete command, etc ..
//          for updating & retrieving all dto's.
//          By using these url patterns, we can determine the appropriate DAO & DTO Objects to create.
//          i.e. CategoryDao, Category : ProductDao, Product, etc ...
//          We simply pass in the last segment of the url to our Dao & Model Factories, which is
//          handled by our AbstractCommand.

public class MainServlet extends HttpServlet {

    private String forwardUrl = "";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        // Get the command
        String command = request.getParameter("cmd");
        
        //JOptionPane.showMessageDialog(null, command, "alert", JOptionPane.ERROR_MESSAGE);
        // Make sure the user is authorised.
        if(!authorised(request,command)){
            return;
        }

        try{
            // Create a new command by passing in the command type required along with the request & response objects.
            AbstractCommand aCommand = CommandFactory.getInstance().createCommand(command, request, response);
            this.forwardUrl = aCommand.execute();
        }
        catch (NullPointerException npe){
            // Most likely, the wrong  path or command was specified that caused either the Dao or Model objects to be null.            
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, npe);    
            this.forwardUrl = MessageService.createNullPointerMessage(MainServlet.class.getName(),npe.getMessage(),request.getSession());
        }     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);  
        request.getRequestDispatcher(this.forwardUrl).forward(request, response); 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        response.sendRedirect(this.forwardUrl);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
       
    
    private boolean authorised(HttpServletRequest request, String commandString){
        
        String servletPath = request.getServletPath();

        // MAKE SURE AN ADMIN CANNOT DELETE THEMSELVES
        if(servletPath.contains("/admin/user") && commandString.equalsIgnoreCase("delete")){            
            int key     = 0; // This is the user id on the '<form>'
            int userid  = 0; // This is the user id of the currently logged in admin.
            try {
                key     = Integer.parseInt(request.getParameter("key"));
                userid  = (Integer) request.getSession().getAttribute("userid");
                if(key == userid){
                    this.forwardUrl = MessageService.createAdminSelfDeleteError(MainServlet.class.getName(), request.getSession());
                    return false;
                }            
            }
            catch(NumberFormatException nfe){
                this.forwardUrl = MessageService.createNumberFormatError(MainServlet.class.getName(), nfe.getMessage(), String.valueOf(key), request.getSession());
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, nfe);
                return false;
            }         
        }
        
        // ANY ACTION FROM THE ADMIN AREA MUST BE AUTHORISED.
        else if(servletPath.contains("/admin/")){             
            UserService uService = new UserService();
            if(!uService.hasAdministrationAuthorisation(request.getSession())){
                forwardUrl =  MessageService.createAuthorisationError(MainServlet.class.getName(),request.getSession());
                return false;
            }
        }
        
        // A CUSTOMER TRYING TO EDIT OR DELETE THEIR DETAILS MUST BE LOGGED IN.
        else if(servletPath.contains("/main/user")){
            if( commandString.equalsIgnoreCase("update") || commandString.equalsIgnoreCase("searchKey")){
                UserService uService = new UserService();
                if(!uService.isLoggedIn(request.getSession())){
                    this.forwardUrl =  MessageService.createAuthorisationError(MainServlet.class.getName(), request.getSession());
                    return false;
                }                  
            }            
        }
        
        // CANNOT LOG IN OR REGISTER IF YOU ARE ALREADY LOGGED IN !!!
        else if(servletPath.contains("/main/user")){
            if( commandString.equalsIgnoreCase("login") || commandString.equalsIgnoreCase("register")){
                UserService uService = new UserService();
                if(uService.isLoggedIn(request.getSession())){
                    this.forwardUrl =  MessageService.createLoggedInError(MainServlet.class.getName(), request.getSession());
                    return false;
                }                 
            }                      
        }        
        // IF WE'VE REACHED THIS POINT, THEN WE ARE AUTHOISED.
        return true;
    }
}
