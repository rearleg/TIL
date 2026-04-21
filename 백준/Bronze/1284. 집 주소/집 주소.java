import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            int ans = 1;
            for (char ch : s.toCharArray()) {
                if (ch == '1') ans += 3;
                else if (ch == '0') ans += 5;
                else ans += 4;
            }
            System.out.println(ans);
        }
    }
}