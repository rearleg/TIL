import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = br.readLine();
            if (in.equals("0000 0000 0000 0000")) break;
            String s = in.replace(" ", "");

            int oddSum = 0;
            int evenSum = 0;
            int result = 0;
            for (int i = 1; i <= s.length(); i++) {
                char c = s.charAt(i - 1);
                if (i % 2 == 1 && c != ' ') {
                    int n = c - '0';
                    int temp = n * 2;
                    if (temp > 9) {
                        oddSum += temp - 9;
                    } else {
                        oddSum += temp;
                    }
                } else if (i % 2 == 0 && c != ' ') {
                    int n = c - '0';
                    evenSum += n;
                }
            }
            result = oddSum + evenSum;

            if (result % 10 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}