import java.util.Arrays;
import java.util.Random;

public class FSM {
    //states/events
    String currentState = "Clear";
    private static final String[] STATES = {"Clear", "Cloudy", "Raining", "Severe Weather"};
    private static final String[] EVENTS = {"Getting Warmer", "Getting Colder", "Humidity is Increasing", "Wind is Increasing"};

    //state transitions
    private static final int left  = 0;
    private static final int no_change = 1;
    private static final int right  = 2;

    private static String performTransition(String currentState, int randomNumber) {
        int nextStateIndex;
        switch (randomNumber) {
            case left :
                nextStateIndex = Math.max(Arrays.asList(STATES).indexOf(currentState) - 1, 0);
                break;
            case no_change:
                nextStateIndex = Arrays.asList(STATES).indexOf(currentState);
                break;
            case right :
                nextStateIndex = Math.min(Arrays.asList(STATES).indexOf(currentState) + 1, STATES.length - 1);
                break;
            default:
                nextStateIndex = Arrays.asList(STATES).indexOf(currentState);
        }
        return STATES[nextStateIndex];
    }
    public static void main(String[] args) {
        String currentState = "Clear";
        Random random = new Random();

        //simulates weather for 7 days
        for (int day = 1; day <= 7; day++) {
            System.out.println("Day " + day + ": " + currentState);

            //performs 5 event changes each day (generates 0 1 or 2)
            for (int eventChange = 1; eventChange <= 5; eventChange++) {
                int randomNumber = random.nextInt(3);
                currentState = performTransition(currentState, randomNumber);

                //display events - it's spaced like that to make it easier to read
                System.out.println("   Event Change " + eventChange + ": " + EVENTS[randomNumber]+ "." + " New State: " + currentState);
            }
        }
    }
}