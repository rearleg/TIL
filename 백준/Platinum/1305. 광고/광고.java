
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] pi = new int[n];

        for (int i = 1, j = 0; i < n; i++){

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = ++j;
            }
        }

        System.out.println(n - pi[pi.length - 1]);
    }

}