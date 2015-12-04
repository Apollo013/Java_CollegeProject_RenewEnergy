package Commands.Login;

import Commands.Abstract.AbstractCommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager; 	
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class LogoutCommand extends AbstractCommand{

    static final Logger logger = LogManager.getLogger(LogoutCommand.class.getName());
        
    public LogoutCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {
        int userid = (Integer)session.getAttribute("userid");
        logger.info("User Logged Out:{}",userid);        
        session.invalidate();       
        return "index.jsp";
    }
    
}
