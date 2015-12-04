package Commands.Login;

import Commands.Abstract.AbstractCommand;
import DataAccess.Abstract.IUserDao;
import DataAccess.Concrete.UserDao;
import Exceptions.DaoException;
import Models.Concrete.User;
import Services.MessageService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager; 	
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class LoginCommand extends AbstractCommand{

    static final Logger logger = LogManager.getLogger(LoginCommand.class.getName());
        
    public LoginCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {

        String      email       = request.getParameter("email");
        String      password    = request.getParameter("password"); 
        IUserDao    udo         = new UserDao(); // can't use super.getDao() as this does not have the login method (it's generic with limited methods)
        User        user        = null;        

        if(email != null && password != null){
            // Fetch the users details
            try {
                user = udo.login(email, password);
            } catch (DaoException ex) {
                forwardPath = MessageService.createDataAccessError(LoginCommand.class.getName(), ex.getMessage(),session);  
                logger.error("Login DaoException: email:{}  password:{}",email,password);
                //Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // If login successful 
            if(user != null){                
                // Store the session id for this client ...
                String clientSessionId = super.session.getId();
                super.session.setAttribute("loggedSessionId", clientSessionId);
                
                // Store user's id, name & user type (admin or member)
                super.session.setAttribute("userid", user.getId());
                super.session.setAttribute("userName", user.getFirstName());
                super.session.setAttribute("userType", user.getUserType());    
                
                forwardPath = "index.jsp";  
                
                logger.info("Login Succeeded: email:{}  password:{}",email,password);
                
                //JOptionPane.showMessageDialog(null,forwardPath,"IO Error",JOptionPane.ERROR_MESSAGE); 
            } else {
                // Login was unsuccessful, so we'll redirect the user back to the login page.
                logger.info("Login Failed: email:{}  password:{}",email,password);
                //LoggerFactory.warn(this.getClass().getName(),"Unable to log in: " + email + " - " + password);
                forwardPath = "login.jsp";
            }
        }  else {
            // Not all details entered, so we'll redirect the user back to the login page.
             forwardPath = "login.jsp";
        }      
        
        return forwardPath;
    }
    
}
