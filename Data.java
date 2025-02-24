public class Data 
{
    // Two static 2D arrays to store data for conversion to and from meters
    private static Object[][] DataToMeter;
    private static Object[][] DataFromMeter;

    // Constructor initializes the arrays with size 'n'
    public Data(int n) 
    {
        DataToMeter = new Object[n][2];  // 2D array for conversion to meters
        DataFromMeter = new Object[n][2];  // 2D array for conversion from meters
    }

    // Returns the length of the DataToMeter array (number of conversion units)
    public static int GetLength()
    {
        return DataToMeter.length;
    }

    // Sets up predefined conversion values from different units to meters
    public static void SetDataToMeter()
    {
        // Unit conversions to meters
        DataToMeter[0][0] = "foot";   // Foot to meter
        DataToMeter[0][1] = 0.3048;    // 1 foot = 0.3048 meters
        
        DataToMeter[1][0] = "inch";   // Inch to meter
        DataToMeter[1][1] = 0.0254;   // 1 inch = 0.0254 meters
        
        DataToMeter[2][0] = "mile";   // Mile to meter
        DataToMeter[2][1] = 1609.344; // 1 mile = 1609.344 meters
        
        DataToMeter[3][0] = "yard";   // Yard to meter
        DataToMeter[3][1] = 0.9144;   // 1 yard = 0.9144 meters
        
        DataToMeter[4][0] = "meter";  // Meter to meter (base unit)
        DataToMeter[4][1] = 1.0;      // 1 meter = 1 meter
        
        DataToMeter[5][0] = "cm";     // Centimeter to meter
        DataToMeter[5][1] = 0.01;    // 1 cm = 0.01 meters
        
        DataToMeter[6][0] = "mm";     // Millimeter to meter
        DataToMeter[6][1] = 0.001;   // 1 mm = 0.001 meters
    }

    // Sets up the DataFromMeter array for converting from meters to other units
    public static void SetDataFromMeter()
    {
        // Copy the unit names from DataToMeter to DataFromMeter
        for(int i = 0; i < DataToMeter.length; i++)
        {
            DataFromMeter[i][0] = DataToMeter[i][0];
        }
        
        // Compute the inverse conversion values for converting from meters
        for(int i = 0; i < DataToMeter.length; i++)
        {
            // Each value in DataFromMeter is the inverse of the corresponding value in DataToMeter
            DataFromMeter[i][1] = 1 / GetDataToMeter((String)DataToMeter[i][0]);
        }
    }

    // Fetches the conversion value from a given unit to meters
    public static double GetDataToMeter(String FromUnit)
    {
        double conv_to_meter = 0.0;
        
        // Iterate through the array and find the conversion factor for the given unit
        for(int i = 0; i < DataToMeter.length; i++)
        {
            // If the unit matches, return the corresponding conversion factor
            if(DataToMeter[i][0].equals(FromUnit))
            {
                conv_to_meter = (double) DataToMeter[i][1];
            }
        }
        return conv_to_meter;
    }

    // Fetches the conversion value from meters to a given unit
    public static double GetDataFromMeter(String ToUnit)
    {
        double conv_from_meter = 0.0;
        
        // Iterate through the DataFromMeter array and find the conversion factor for the given unit
        for(int i = 0; i < DataFromMeter.length; i++)
        {
            // If the unit matches, return the corresponding conversion factor
            if(DataFromMeter[i][0].equals(ToUnit))
            {
                conv_from_meter = (double) DataFromMeter[i][1];
            }
        }
        return conv_from_meter;
    }
}