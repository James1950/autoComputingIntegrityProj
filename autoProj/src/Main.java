import java.io.*;
import java.util.ArrayList;

public class Main {

    //alternative module order, controls (inside brackets), & check status
    public static boolean isCorrectMod(String cat, int senderEcu){
        switch(senderEcu) {
            case 1:
                getMod1Controls();
                break;
            case 2:
                getMod2Controls();
                break;
            default:
                getMod3Controls();
        }
        return true;
    }
    private static String[] mod1Controls = {"ABS", "ERPM", "TL", "EI", "TCS"};

    public static String[] getMod1Controls() {
        return mod1Controls;
    }

    public static String[] getMod2Controls() {
        return mod2Controls;
    }

    public static String[] getMod3Controls() {
        return mod3Controls;
    }

    public static int[] getMod1Fallback() {
        return mod1Fallback;
    }

    public static int[] getMod2Fallback() {
        return mod2Fallback;
    }

    public static int[] getMod3Fallback() {
        return mod3Fallback;
    }

    public static boolean isMod1Status() {
        return mod1Status;
    }

    public static boolean isMod2Status() {
        return mod2Status;
    }

    public static boolean isMod3Status() {
        return mod3Status;
    }

    private static String[] mod2Controls = {"CPA", "MSAD", "CA"};
    private static String[] mod3Controls = {"SC", "GPS"};
    private static int[] mod1Fallback = {2,3};
    private static int[] mod2Fallback = {1,3};
    private static int[] mod3Fallback = {2,1};
    private static boolean mod1Status = true;
    private static boolean mod2Status = true;
    private static boolean mod3Status = true;

    public static void main(String[] args) throws Exception {

        Vehicle v = new Vehicle(isMod1Status(),isMod2Status(),isMod3Status(), getMod1Fallback(),  getMod2Fallback(),getMod3Fallback(),0,0,0,0,0,0, 0 ,0, 0, 0, 0);
        System.out.print("This is the initial state of the vehicle:\n");
        System.out.println();
        File file = new File("autoProj/src/Initial_State_of_Vehicle.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String[]> list = new ArrayList<String[]>();
        String st;

        while ((st = br.readLine()) != null){
            System.out.println(st);
            String field = st.split(" , ")[0];
            String val = (st.split(" ,")[1]).split(" ,")[0];
//            int ecu = Integer.parseInt(st.split(" , ")[2]);
            setupCar(v, field, val, true);
        }
//            list.append(st);
        System.out.println("\n");
        System.out.print("This is the altered state of the vehicle:");
    }

    private static void setupCar(Vehicle v, String field, String val, Boolean correct) {
        switch(field) {
            case "ABS":
                if(correct)
                    v.setAbs(Integer.parseInt(val));
                break;
            case "SC":
                v.setSc(Integer.parseInt(val));
                break;
            case "CA":
                v.setCa(Integer.parseInt(val));
                break;
            case "ERPM":
                // code block
                break;
            case "TL":
                // code block
                break;
            case "EI":
                // code block
                break;
            case "MSAD":
                // code block
                break;
            case "CPA":
                // code block
                break;
            case "TCS":
                // code block
                break;
            case "GPS":
                // code block
                break;
            default:
                // code block

        }
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
/* future mods - add in an ECU class to contain it all*/