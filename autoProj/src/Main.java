import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //alternative module order, controls (inside brackets), & check status
    public static boolean isCorrectMod(String cat, int senderEcu, boolean ecuActive){
        String[] controlSet = getControlSet(senderEcu);
        if(Arrays.asList(controlSet).contains(cat) && ecuActive){
            return true;
        }
        else{
            int tempIndex = -1;
                    String[][] fallbacks = {getMod1Controls(), getMod2Controls() , getMod3Controls()};
                    for (int k = 0; k < fallbacks.length; k++){
                        if(Arrays.asList(fallbacks[k]).contains(cat)){
                            tempIndex = k+1;
                            break;
                        }
                    }
                    if(tempIndex != -1){

                        Boolean x;
                        if (tempIndex == 1){
                            x = isMod1Status();
                        }
                        else if(tempIndex == 2){
                            x = isMod2Status();
                        }
                        else {
                            x = isMod3Status();
                        }
                        if(x){
                            return false;
                        }
                        int[] fallbackers = getFallbackSet(tempIndex);
                        for (int r= 0; r< fallbackers.length; r++){
                            if (fallbackers[r] == 1){
                                x = isMod1Status();
                            }
                            else if(fallbackers[r] == 2){
                                x = isMod2Status();
                            }
                            else {
                                x = isMod3Status();
                            }

                            if(x){
                                if(fallbackers[r] == senderEcu){
                                    return true;
                                }
                                else{
                                    return false;
                                }

                            }
                        }


                    }


                return false;
            }

        }


    private static String[] getControlSet(int senderEcu) {
        String[] controlSet;
        switch(senderEcu) {
            case 1:
                controlSet = getMod1Controls();
                break;
            case 2:
                controlSet = getMod2Controls();
                break;
            default:
                controlSet = getMod3Controls();
        }
        return controlSet;
    }

    private static int[] getFallbackSet(int senderEcu) {
        int[] controlSet;
        switch(senderEcu) {
            case 1:
                controlSet = getMod1Fallback();
                break;
            case 2:
                controlSet = getMod2Fallback();
                break;
            default:
                controlSet = getMod3Fallback();
        }
        return controlSet;
    }

    private static String[] mod1Controls = {"ABS", "ERPM", "TL", "EI", "TCS", "ICV-F"};

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

    private static boolean isInIDSMode = false;
    private static boolean mod2Status = true;
    private static boolean mod3Status = false;

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
            String field = st.split(" ,")[0];
            String val = (st.split(" ,")[1]).split(" ,")[0];
//            int ecu = Integer.parseInt(st.split(" , ")[2]);
            setupCar(v, field, val, true);
        }
//            list.append(st);
        System.out.println("\n");
        System.out.print("This is the altered state of the vehicle:\n\n");

        file = new File("autoProj/src/test.txt");
        br = new BufferedReader(new FileReader(file));

        while ((st = br.readLine()) != null){
            System.out.println(st);
            String field = st.split(" ,")[1];
            String val = st.split(" ,")[2];
            int ecu = Integer.parseInt(st.split(" ,")[0]);
            setupCar(v, field, val, isCorrectMod(field, ecu, v.getEcuState(ecu)));
        }
    }

    private static void setupCar(Vehicle v, String field, String val, Boolean correct) {
        switch(field) {
            case "ABS":
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, ABS not set to " + val);
                }


                else{
                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ABS set to " + val);
                }
                break;
            case "SC":
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, SC not set to " + val);
                }


                else{
                    v.setSc(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("SC set to " + val);
                }
                break;
            case "CA":
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, CA not set to " + val);
                }


                else{
                    v.setCa(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("CA set to " + val);
                }
                break;
            case "ERPM":
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, ERPM not set to " + val);
                }


                else{
                    v.setErpm(Integer.parseInt(val.split(" rpm")[0]));
//                    print message not received or something
                    System.out.println("ERPM set to " + val);
                }


                break;
            case "TL":

                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, TL not set to " + val);
                }


                else{
                    v.setTl(Double.parseDouble(val.split(" volts")[0]));
//                    print message not received or something
                    System.out.println("TL set to " + val);
                }

                break;
            case "EI":

                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, EI not set to " + val);
                }


                else{
                    v.setEi(Integer.parseInt(val.split(" rpm")[0]));
//                    print message not received or something
                    System.out.println("EI set to " + val);
                }


                break;
            case "ICV-F":

                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, ICV-F not set to " + val);
                }


                else{
                    v.setIcvf(Double.parseDouble(val.split(" volts")[0]));
//                    print message not received or something
                    System.out.println("ICV-F set to " + val);
                }

                break;
            case "MSAD":
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, MSAD not set to " + val);
                }


                else{
                    v.setMsad(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("MASD set to " + val);
                }


                break;
            case "CPA":
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, CPA not set to " + val);
                }


                else{
                    v.setCpa(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("CPA set to " + val);
                }




                break;
            case "TCS":
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, TCS not set to " + val);
                }


                else{
                    v.setTcs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("TCS set to " + val);
                }

                break;
            default:
                if(!correct && isInIDSMode == false){
//                    v.setAbs(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("ECU not correct, GPS not set to " + val);
                }


                else {
                    v.setGps(Integer.parseInt(val));
//                    print message not received or something
                    System.out.println("GPS set to " + val);
                }

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
/* future mods - add in an ECU class to contain it all
* modify the status of the ECU if needed (could be something done later)
* */