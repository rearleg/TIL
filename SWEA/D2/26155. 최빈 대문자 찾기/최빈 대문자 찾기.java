
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] arr = new int[26];

            for (char ch : s.toCharArray()) {
                if (ch != ' ') {
                    arr[ch - 'A']++;
                }

            }

            int max = 0;
            int maxIdx = 0;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIdx = i;
                }
            }

            System.out.println("#"+tc+" "+(char)(maxIdx+'A'));

        }
    }
}
