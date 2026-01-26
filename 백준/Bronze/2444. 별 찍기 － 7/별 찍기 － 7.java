import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mid = n - 1;

        for(int i = 0; i < 2 * n - 1; i++) {
            int space =Math.abs(mid-i);
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            int star = 2 * n - 2 * space - 1;
            for (int k = 0; k < star; k++) {;
                System.out.print("*");
            }

            System.out.println();

        }

    }
}
