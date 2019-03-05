
import java.util.concurrent.Semaphore;
/**
 * @Benjamin Bennett
 * @John Draper
 * @Thomas Gorham
 * 04 March 2019
 * CPSC 2800.22971
 */
public class Bridge
{
    private Semaphore bridgeKey;
    
    
    /**
     * Constructor for objects of class Bridge
     */
    public Bridge()
    {
        
     bridgeKey = new Semaphore(1);   
    }
    /**
     * Method that will be attempted by all threads upon start to 
     * acquire semaphore
     */
    public void cross()
    {  
        try 
        {
            bridgeKey.acquire();   
        }
        catch (InterruptedException e) {}
    }
    /**
     * Method to release semaphore when done with critical instructions
     */
    public void done()
    {
       bridgeKey.release();
    }
}