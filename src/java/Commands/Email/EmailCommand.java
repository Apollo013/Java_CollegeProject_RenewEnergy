package Commands.Email;

import Commands.Abstract.AbstractCommand;
import Services.MessageService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class EmailCommand extends AbstractCommand{

    public EmailCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {
             
        // THIS CODE WILL NOT WORK IN DKIT BUT WILL AT HOME ????
/*
        String name     =   request.getParameter("name");
        String sendTo   =   request.getParameter("email");      
        String subject  =   "Renew Enrgy Group";
        String body     =   "\nThank you for contacting us " + name + 
                            ".\n\nA member of our team will be in touch with you shortly in relation to your query." +
                            "\n\n\nKindest Regards\nRenew Energy Group";
        
        try {
            EmailService email = new EmailService();
            email.sendMail(sendTo, subject, body);
            forwardPath = MessageService.createContactConfirmMessage(session);           
        } catch (MessagingException ex) {
            forwardPath = MessageService.createEmailError(EmailCommand.class.getName(), ex.getMessage(), session);             
            Logger.getLogger(EmailCommand.class.getName()).log(Level.SEVERE, null, ex);             
        }    
 */
        forwardPath = MessageService.createContactConfirmMessage(session);
        return forwardPath;         

    }
    
}
