import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mid = n - 1;

        for(int i = 0; i < 2 * n - 1; i++) {

            int star = n - Math.abs(mid - i);
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }

            int space = 2 * n - 2 * star;
            for (int k = 0; k < space; k++) {;
                System.out.print(" ");
            }

            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            
            System.out.println();

        }

    }
}
