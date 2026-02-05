
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += Integer.parseInt(br.readLine());
        }
        System.out.println(ans);
    }
}