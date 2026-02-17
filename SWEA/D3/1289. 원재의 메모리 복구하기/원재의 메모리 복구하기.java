import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 입력 받기
            String s = br.readLine();
            char prev = '0';
            int cnt = 0;
            for (char ch : s.toCharArray()) {
                if (prev != ch) {
                    prev = ch;
                    cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);

        }
    }

}