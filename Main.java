// Importing the Scanner class for taking user input from the console
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        // Creating a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter the amount they want to convert
        System.out.print("Enter the amount you want to convert: ");
        double amount = sc.nextDouble(); // Reading the amount as a double

        // Asking the user for the unit they are converting from
        System.out.print("\nEnter the distance unit you are converting from (foot, inch, mile, yard, meter, cm, mm): ");
        String FromUnit = sc.next(); // Reading the "from" unit as a string

        // Asking the user for the unit they are converting to
        System.out.print("\nEnter the distance unit you are converting to (foot, inch, mile, yard, meter, cm, mm): ");
        String ToUnit = sc.next(); // Reading the "to" unit as a string

        // Calling the Converter method from the Convert class to perform the conversion
        double res = Convert.Converter(amount, FromUnit, ToUnit, 7);

        // Displaying the conversion result in a formatted output
        System.out.printf("%f %s = %f %s\n", amount, FromUnit, res, ToUnit);
        
        // Closing the Scanner to prevent memory leaks
        sc.close();
    }
}