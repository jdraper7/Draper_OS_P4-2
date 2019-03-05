import java.util.Random;

/**
 * @Benjamin Bennett
 * @John Draper
 * @Thomas Gorham
 * 04 March 2019
 * CPSC 2800.22971
 */
public class BridgeTester
{
    public static void main(String[] Args){
    //Creates a randomizer to assign directions to cars in thread pool
    Random rng = new Random();
    String[] directions = {"West","East"};
    //Creates an array of 10 car objects
    Car[] cars = new Car[10];
    //Creates a new Bridge object
    Bridge myBridge = new Bridge();
    //Fills cars array with car objects
    for (int i = 0; i < cars.length; i++)
    {   
        cars[i] = new Car(myBridge, directions[rng.nextInt(2)]);       
    }
    //Starts all cars, which extend Thread
    for (int i = 0; i < cars.length; i++)
    {   
        cars[i].start();
    }
}
}