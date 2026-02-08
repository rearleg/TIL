import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int[] charCnt = new int[26];

        for (char ch : s.toCharArray()) {
            charCnt[ch - 'A']++;
        }

        int max = 0;
        int ans = 0;
        boolean same = false;
        for (int i = 0 ; i < 26; i++) {
            if (max != 0 && max == charCnt[i]) {
                same = true;
            }
            if (max < charCnt[i]) {
                same = false;
                max = charCnt[i];
                ans = i;
            }

        }
        if (same) System.out.println('?');
        else System.out.println((char) (ans + 'A'));
    }
}