package OtherTesting;

import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class ErrorBaseTest {
    
    public ErrorBaseTest() {
    }
    
    
    @Test
    public void testErrorBase() throws ClassNotFoundException{
        
        ErrorModel em = new ErrorModel();
        try {
            boolean rv = em.isValid();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ErrorBaseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ErrorBaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(String s : em.getErrorMessages()){
            System.out.println(s.toString());
        }
        int actual = em.errorCount();
        int expected = 26;
        Assert.assertEquals(expected, actual);
        
        
        System.out.println("\nTHIS IS THE TO STRING PRINT OUT");
        System.out.println(em.toErrorString());
    }

    
}
