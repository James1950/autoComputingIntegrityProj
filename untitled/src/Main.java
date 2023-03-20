import java.io.*;
import java.util.ArrayList;

public class Main {

    //alternative module order, controls (inside brackets), & check status
    private String[] mod1Controls = {"ABS", "ERPM", "TL", "EI", "TCS"};
    private String[] mod2Controls = {"CPA", "MSAD", "CA"};
    private String[] mod3Controls = {"SC", "GPS"};
    private int[] mod1Fallback = {2,3};
    private int[] mod2Fallback = {1,3};
    private int[] mod3Fallback = {2,1};
    private boolean mod1Status = true;
    private boolean mod2Status = true;
    private boolean mod3Status = true;

    public static void main(String[] args) throws Exception {
        System.out.print("This is the initial state of the vehicle:\n");
        System.out.println();
        File file = new File("untitled/src/Initial_State_of_Vehicle.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String[]> list = new ArrayList<String[]>();
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
        System.out.println("\n");
        System.out.print("This is the altered state of the vehicle:");



    }

}

// if we receive a signal from module, look for string in mod to see if it's there; if it is not , reject message
// if the module is down, look for backup and accept number coming in.
// if no backup is found, reject number.
// module status
// module controller
// module status -- controls backups

/*
1 = constant state (may be being used or just running in background)
0 = off and unavaiable (even if switched too)
 - ABS  - Brakes (anti-lock brake system control) ABS
 - SC   - Steering column
 - CA   - Collision assist (blind spot, breaking, lanekeep assist) ... lidar sensors
 - ERPM - Engine rpm (engine timings for fuel injection)
 - TL   - Throttle limiter (throttle position sensor)  1 = 3.5-4.7 volts, 0 = not pushed down
 - EI   - Engine idle - (spark events and valve timing)
 - MSAD - Motion sensors for automatic doors
 - CPA  - Computer parking assistant (visual)
 - TCS  -Traction control (wheel slipping)
 - GPS  -Autonomous vehicle GPS
 */
