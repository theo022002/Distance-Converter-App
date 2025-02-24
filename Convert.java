// This class handles the conversion logic between different distance units
public class Convert 
{
    // Method to convert a given amount from one unit to another
    public static double Converter(double amount, String FromUnit, String ToUnit, int n)
    {
        // Creating an instance of the Data class to store conversion rates
        Data data = new Data(7);
        
        // Initializing conversion rates from various units to meters
        data.SetDataToMeter();
        
        // Initializing conversion rates from meters to various units
        data.SetDataFromMeter();
        
        // Variable to store the conversion factor
        double conv = 0.0;
        
        // If converting from meters to another unit
        if(FromUnit.equals("meter"))
        {
            conv = data.GetDataFromMeter(ToUnit);
        }
        // If converting from another unit to meters
        else if(ToUnit.equals("meter"))
        {
            conv = data.GetDataToMeter(FromUnit);
        }
        // If converting between two non-meter units
        else
        {
            // Convert from the initial unit to meters, then from meters to the target unit
            conv = data.GetDataToMeter(FromUnit) * data.GetDataFromMeter(ToUnit);
        }
        
        // Calculating the final converted amount
        double res = amount * conv;
        
        // Returning the converted value
        return res;
    }    
}