

/**
 * Project 4-1
 * This program decomposes a virtual address into a page number and an offset within the page. 
 *
 * @author (John Draper; Benjamin Bennet; Thomas Gorham) 
 * @course (CPSC 2800; Dr. Mudali)
 * @version (03 March, 2019)
 */
import java.util.Scanner;
public class VirtualAddressFinder
{
    /**
     * This method determines the power of 2 associated with a given page size.
     * @param num the specified page size
     */
    public static int findPowerOfTwo(long num)
    {
        if(num == 0)
        {    
            return -1; //0 is not accepted.
        }
        
        int count = 0; //this counter tracks the powers of two
        while(num != 1)
        {
            if((num % 2 == 0))
            {
                num = num / 2;
                count++; //update the counter each time num is divisible by 2.
            }
            else
            {
                return -1; //return -1 if the page size is not a power of two.
            }
        }
        return count; //return the power of two to the user
    }
    
    public static void main(String[] args)
    {
        //the page sizes must be a power of two between 2^9 and 2^14
        //these constants represent the powers of 9 and 14
        final int MIN_PAGES = 9;
        final int MAX_PAGES = 14;
        
        //the virtual address must be 0 and 2^32-1
        //these constants represent the those powers
        final int MIN_ADDRESS = 0;
        final int MAX_ADDRESS = 32;
        
        Scanner in = new Scanner(System.in);
        
        //prompt the user for the page size
        long pageSize = 0;
        System.out.println("Please enter the system page size: ");
        pageSize = in.nextLong();
        int powerTwo = findPowerOfTwo(pageSize); //call the findPowerOfTwo() method to find the power of 2 associated with the selected page size
        
        //verify that the powerTwo associated with pageSize is between 512 and 16384, which is 2^9 and 2^14, respectively.
        if((powerTwo == -1) || (powerTwo < MIN_PAGES) || (powerTwo > MAX_PAGES))
        {
            System.out.println("Not a valid page size. Value must be between " + (int)Math.pow(2,MIN_PAGES) + " and " + (int)Math.pow(2,MAX_PAGES));
        }
        
        
        //prompt the user for the virtual address
        long virtualAddress = 0;
        System.out.println("Please enter a virtual address: ");
        virtualAddress = in.nextLong();
        
        //verify that the virtual address is between 0 and 4294967295, which is 2^32-1
        if((virtualAddress < 0) || (virtualAddress > ((long)Math.pow(2,MAX_ADDRESS)-1)))
        {
            System.out.println("Not a valid virtual address. Value must be between " + MIN_ADDRESS + " and " + ((long)Math.pow(2, MAX_ADDRESS)-1));
        }
        
        //print the results to the user
        System.out.println("The address is in virtual page: " + (virtualAddress / pageSize)); //output the address location
        System.out.println("At offset: " + (virtualAddress % pageSize)); //display the offset using remainder division
    }
}
