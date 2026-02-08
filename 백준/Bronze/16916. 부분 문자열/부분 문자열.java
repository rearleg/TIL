import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        System.out.println(kmp(s, p) ? 1 : 0);

    }

    static int[] buildPi(String p) {
        int n = p.length();
        int[] pi = new int[n];

        for (int i = 1, j = 0; i < n; i++) {
            while(j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    static boolean kmp (String s, String p) {
        int n = s.length();
        int m = p.length();

        int[] pi = buildPi(p);

        for (int i =0, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                if (j == m - 1) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
