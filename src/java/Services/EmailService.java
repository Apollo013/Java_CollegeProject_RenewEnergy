package Services;

import Models.Concrete.User;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class EmailService {
    
    // WARNING - THIS DOES NOT WORK ON DKIT SERVER
    
    public void sendMail(String to, String subject, String body) throws MessagingException{
        
        final String fromMailAddress  = "renewenergyg@gmail.com";
        final String password         = "pogmathon1.";
        
        Properties props = new Properties();
        //props.put("mail.transport.protocol", "smtps");
        props.put("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(props,new Authenticator() {@Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(fromMailAddress, password);
        }});
        
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMailAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            
            Transport.send(message);            
        }
        catch (MessagingException me){
            throw new RuntimeException(EmailService.class.getName() + me.getMessage());
        }        
    }
        
    public void emailUser(User user, String emailType){
        
        String body     = "";
        String subject  = "";
        
        if(emailType.equalsIgnoreCase("registration")){
            body =  MessageService.createRegistrationConfirmEmailBody(user.getFirstName()); 
            body += getSignature();
            subject = getSubject("Registration");
        }
        
        try {
            sendMail(user.getEmail(), subject, body);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getSignature(){
        return "\n\n\nKindest Regards\nRenew Energy Group";
    }
    
    private String getSubject(String subject){
        return "Renew Energy Group " + subject;
    }
}
