package Services;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class UserService {
    
    public boolean hasAdministrationAuthorisation(HttpSession session){
        byte userType = (Byte) session.getAttribute("userType");        
        return (userType == 1 && isLoggedIn(session));
    }
    
    public boolean isLoggedIn(HttpSession session){
        return (session.getAttribute("loggedSessionId") != null && session.getAttribute("userid") != null);
    }    

}
