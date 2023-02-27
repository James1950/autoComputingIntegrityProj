import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("untitled/src/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String[]> list = new ArrayList<String[]>();
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }
}
