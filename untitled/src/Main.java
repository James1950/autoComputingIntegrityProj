import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("This is the initial state of the vehicle:\n");
        System.out.println();
        File file = new File("untitled/src/Initial_State_of_Vehicle.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String[]> list = new ArrayList<String[]>();
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }
}

// if we receive a signal from module, look for string in mod to see if it's there; if it is not , reject message
// if the module is down, look for backup and accept number coming in.
// if no backup is found, reject number.
// module status
// module controller
// module status -- controls backups
