import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {

            for (int j = n-1-i; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * i + 1; k++) {
//                System.out.println(k);
                System.out.print("*");
            }
            
            System.out.println();

        }

    }
}
