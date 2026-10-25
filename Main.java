
/**
 * EV Charging Calculator
 *
 * Calculates charging power and estimated charging time
 * for electric vehicles using single-phase (230 V) and
 * three-phase (400 V) charging configurations.
 *
 */

public class Main {
    // Constants
    public static final double BATTERY_CAPACITY = 35.8; // kWh
    public static final double W_TO_KW = 1000.0;
    public static final double VOLTAGE_230 = 230.0;
    public static final double VOLTAGE_400 = 400.0;
    public static final double AMPERE_10 = 10.0;
    public static final double AMPERE_16 = 16.0;
    public static final double AMPERE_32 = 32.0;
    public static final int BASE_10 = 10;

    /**
     * Main method for calculating and displaying EV charging times.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(final String[] args) {
        // Variables for charging power and time
        double chargingPower1;
        double chargingPower2;
        double chargingPower3;
        double chargingPower4;
        double chargingPower5;

        double chargingTime1;
        double chargingTime2;
        double chargingTime3;
        double chargingTime4;
        double chargingTime5;


        // Setup for rounding results to two decimal places
        int noOfDecimals = 2;
        double scale = Math.pow(BASE_10, noOfDecimals);

        // Calculate charging power for different configurations
        chargingPower1 = (AMPERE_10 * VOLTAGE_230) / W_TO_KW; // Single-phase
        chargingPower2 = (AMPERE_16 * VOLTAGE_230) / W_TO_KW; // Single-phase
        chargingPower3 = (AMPERE_10 * VOLTAGE_400 * Math.sqrt(3)) / W_TO_KW; // Three-phase
        chargingPower4 = (AMPERE_16 * VOLTAGE_400 * Math.sqrt(3)) / W_TO_KW; // Three-phase
        chargingPower5 = (AMPERE_32 * VOLTAGE_400 * Math.sqrt(3)) / W_TO_KW; // Three-phase

        // Round charging power to two decimal places
        chargingPower1 = Math.round(chargingPower1 * scale) / scale;
        chargingPower2 = Math.round(chargingPower2 * scale) / scale;
        chargingPower3 = Math.round(chargingPower3 * scale) / scale;
        chargingPower4 = Math.round(chargingPower4 * scale) / scale;
        chargingPower5 = Math.round(chargingPower5 * scale) / scale;

        // Calculate charging time
        chargingTime1 = BATTERY_CAPACITY / chargingPower1;
        chargingTime2 = BATTERY_CAPACITY / chargingPower2;
        chargingTime3 = BATTERY_CAPACITY / chargingPower3;
        chargingTime4 = BATTERY_CAPACITY / chargingPower4;
        chargingTime5 = BATTERY_CAPACITY / chargingPower5;

        // Round charging time to two decimal places
        chargingTime1 = Math.round(chargingTime1 * scale) / scale;
        chargingTime2 = Math.round(chargingTime2 * scale) / scale;
        chargingTime3 = Math.round(chargingTime3 * scale) / scale;
        chargingTime4 = Math.round(chargingTime4 * scale) / scale;
        chargingTime5 = Math.round(chargingTime5 * scale) / scale;

        // Print the results in a table format
        System.out.printf("Battery: %.2f (kWh)\n", BATTERY_CAPACITY);
        System.out.printf("%-12s %-12s %-19s %-15s\n", 
            "Current(A)", "Voltage(V)", "Charging Power(kW)", "Charging Time(h)");
        System.out.printf("%-12.1f %-12.1f %-19.2f %-15.2f\n", AMPERE_10, VOLTAGE_230, chargingPower1, chargingTime1);
        System.out.printf("%-12.1f %-12.1f %-19.2f %-15.2f\n", AMPERE_16, VOLTAGE_230, chargingPower2, chargingTime2);
        System.out.printf("%-12.1f %-12.1f %-19.2f %-15.2f\n", AMPERE_10, VOLTAGE_400, chargingPower3, chargingTime3);
        System.out.printf("%-12.1f %-12.1f %-19.2f %-15.2f\n", AMPERE_16, VOLTAGE_400, chargingPower4, chargingTime4);
        System.out.printf("%-12.1f %-12.1f %-19.2f %-15.2f\n", AMPERE_32, VOLTAGE_400, chargingPower5, chargingTime5);
    }
}
