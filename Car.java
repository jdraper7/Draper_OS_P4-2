
/**
 * @Benjamin Bennett
 * @John Draper
 * @Thomas Gorham
 * 04 March 2019
 * CPSC 2800.22971
 */

public class Car extends Thread implements Runnable
{
    
    private String path;
    private Bridge bridge;
    /**
     * Constructor for objects of class Cars
     */
    public Car(Bridge bridge,String path)
   {
        this.path = path;
        this.bridge = bridge;
   }
   /**
    * Accessor method for path variable
    * @return String path
    */
   public String getPath()
   {       
       return path;
   }
   /**
    * Run method override for objects of Car class
    */
   public void run() 
   {
       //Sleeps momentarily to allow other threads to start
       try
       {
           Thread.sleep(5000);
       }
       catch (InterruptedException e) {}
       //attempts to take control of bridge through semaphore
       bridge.cross();
       System.out.println("A car is attempting to cross the bridge");
       //sleeps momentarily on bridge to simulate crossing
       try
       {
           Thread.sleep(10000);
       }
       catch (InterruptedException e) {}
       //Relinquishes control of semaphore
       System.out.println("A car has crossed the bridge travelling " + getPath());
       bridge.done();
       //sleeps momentarily, until another thread can gain control of semaphore
       try
       {
           Thread.sleep(500);
       }
       catch (InterruptedException e) {}
    }
}