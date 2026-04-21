import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int burger = Integer.MAX_VALUE;
        int drink = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++){
            burger = Math.min(burger, arr[i]);
        }
        for (int i = 3; i < arr.length; i ++ ) {
            drink = Math.min(drink, arr[i]);
        }

        bw.write(String.valueOf(burger + drink - 50));
        bw.flush();

    }
}