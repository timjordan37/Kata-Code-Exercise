import java.util.Scanner;

public class PayCalculator {

    //variables for pay rate and shift times
    private int startTime;
    private int shiftEnd;
    private int bedTime;
    private static final int START_TIME_TO_BEDTIME_RATE = 12;
    private static final int FROM_BEDTIME_TO_MIDNIGHT_RATE = 8;
    private static final int FROM_MIDNIGHT_TO_END_OF_SHIFT_RATE = 16;

    public PayCalculator(int startTime, int shiftEnd, int bedTime) {
        this.startTime = amTimeConversion(startTime);
        this.shiftEnd = amTimeConversion(shiftEnd);
        this.bedTime = amTimeConversion(bedTime);
    }

    //checks if shift time is valid
    boolean isValidShiftTime() {
        return ((startTime >= 17 && startTime < 28) && (shiftEnd <= 28 && shiftEnd > 17));
    }

    //checks if general user input is valid
    boolean isValidUserInput() {
        return startTime < shiftEnd && startTime >= 17 && shiftEnd >= 17 && bedTime >= 17;
    }

    //adds 24 to AM time for calculations and validity checks
    int amTimeConversion(int am) {
        return (am <= 4) ? am + 24 : am;
    }

    //pay calculations based on shift time and differing rates
    public int payCalculations() {
        int result = 0;
        if(!isValidShiftTime()) {
            return 0;
        }
        for(int i = startTime; i < shiftEnd; i++) {
            if(i < bedTime && i < 24) {
                result += START_TIME_TO_BEDTIME_RATE;
            } else if(i >= bedTime && i < 24) {
                result += FROM_BEDTIME_TO_MIDNIGHT_RATE;
            } else {
                result += FROM_MIDNIGHT_TO_END_OF_SHIFT_RATE;
            }
        }
        return result;
    }

    //main method
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\nSimple Babysitter Pay Calculator\n");
            System.out.println("Key:\nValid hours are between 5PM and 4AM\nStart time to bedtime: $12/hr\n" +
                    "Bedtime to midnight: $8/hr\nMidnight to end of shift: $16/hr");

            System.out.println("\nEnter shift start time in 24 hour time format:");
            int start = sc.nextInt();
            System.out.println("\nEnter shift end time in 24 hour time format:");
            int end = sc.nextInt();
            System.out.println("\nEnter bedtime in 24 hour time format:");
            int bedtime = sc.nextInt();

            PayCalculator payment = new PayCalculator(start, end, bedtime);

            //determines whether user input is valid or not
            if (payment.isValidShiftTime() && payment.isValidUserInput()) {
                System.out.println("\nPayment for your shift is: " + "$" + payment.payCalculations());
            } else {
                System.out.println(
                        "\nInvalid hours. Please enter hours from 5PM - 4AM");

                //resets main method if invalid entry is given
                main(args);
            }
        }
    }
}