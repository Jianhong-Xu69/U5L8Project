public class Temperature
{
    private double highTemp;
    private double lowTemp;
    private String tempScale;
    private static double highestTrackedTempF;
    private static double lowestTrackedTempF;
    private static boolean first = true;
    public static final int FREEZING_TEMP_F = 32;

    // Precondition: scale must be: "F" or "C"; anything else will default to "F"
    public Temperature(double high, double low, String scale)
    {
        highTemp = rounder(high);
        lowTemp = rounder(low);

        if (scale.equals("F") || scale.equals("C"))
        {
            tempScale = scale;
        }
        else
        {
            tempScale = "F";
        }
        if (first) {
            if (tempScale.equals("C")) {
                highestTrackedTempF = convertCtoF(highTemp);
                lowestTrackedTempF = convertCtoF(lowTemp);
            } else {
                highestTrackedTempF = highTemp;
                lowestTrackedTempF = lowTemp;
            }
        }
        first = false;
        if (tempScale.equals("C")) {
            if (convertCtoF(highTemp) > highestTrackedTempF) {
                highestTrackedTempF = convertCtoF(highTemp);
            }
            if (convertCtoF(lowTemp) < lowestTrackedTempF) {
                lowestTrackedTempF = convertCtoF(lowTemp);
            }
        } else {
            if (highTemp > highestTrackedTempF) {
                highestTrackedTempF = highTemp;
            }
            if (lowTemp < lowestTrackedTempF) {
                lowestTrackedTempF = lowTemp;
            }
        }
    }

    // 1. Add your two static methods here:
    public static double convertCtoF(double c) {
        return (c * (9.0/5.0)) + 32;
    }
    public static double convertFtoC(double f) {
        return (f - 32) * (5.0/9.0);
    }

    // 2. Add your two instance methods here:
    public void changeToC() {
        if (!tempScale.equalsIgnoreCase("C")) {
            tempScale = "C";
            highTemp = rounder(convertFtoC(highTemp));
            lowTemp = rounder(convertFtoC(lowTemp));
        }
    }
    public void changeToF() {
        if (!tempScale.equalsIgnoreCase("F")) {
            tempScale = "F";
            highTemp = rounder(convertCtoF(highTemp));
            lowTemp = rounder(convertCtoF(lowTemp));
        }
    }
    //U5L8 mandated instance methods
    public boolean belowFreezing() { //hey just me talking here, but if the highTemp is freezing but the lowTemp isn't, what drugs are you on and what hellhole do you live
        if (tempScale.equals("C")) {
            return convertCtoF(highTemp) < FREEZING_TEMP_F || convertCtoF(lowTemp) < FREEZING_TEMP_F;
        } else {
            return highTemp < FREEZING_TEMP_F || lowTemp < FREEZING_TEMP_F;
        }
    }

    //U5L8 mandated static methods
    public static boolean sawFreezing() {
        return highestTrackedTempF < FREEZING_TEMP_F || lowestTrackedTempF < FREEZING_TEMP_F; //What planet are you on?
    }

    //U5L8 mandated getters
    public String getHighTemp() {
        return highTemp + " " + tempScale;
    }
    public String getLowTemp() {
        return lowTemp + " " + tempScale;
    }

    public String getTempScale() {
        return tempScale;
    }

    public static String getHighestTrackedTempF() {
        return highestTrackedTempF + " F";
    }

    public static String getLowestTrackedTempF() {
        return lowestTrackedTempF + " F";
    }

    // 3. Add your private static helper rounding "utility" method here:
    private static double rounder(double temp) {
        return Math.round(temp * 10.0) / 10.0;
    }

    // 4. Complete the toString method below (using your static helper method)
    //    so it returns a String that prints like:

    //    High Temperature: 67.4 F (or C)
    //    Low Temperature: 58.3 F (or C)

    public String toString()
    {
        return "High Temperature: " + highTemp + " " + tempScale + "\nLow Temperature: " + lowTemp + " " + tempScale;
    }
}