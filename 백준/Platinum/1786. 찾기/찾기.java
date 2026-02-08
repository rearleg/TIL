
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    static int cnt = 0;
    static List<Integer> matchIdx;

    public static void main(String[] args) throws Exception {
        // 초기화
        matchIdx = new ArrayList<>();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();

        kmp(t, p);

        System.out.println(cnt);
        System.out.println(matchIdx.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

    static int[] buildPi(String p) {
        int n = p.length();
        int[] pi = new int[n];

        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }

    static boolean kmp(String t, String p) {
        int n = t.length();
        int m = p.length();

        if (m == 0) return true;

        int[] pi = buildPi(p);

        for (int i = 0, j = 0; i < n; i++) {

            // 불일치
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            // 일치
            if (t.charAt(i) == p.charAt(j)) {
                if (j == m - 1) {
                    cnt++;
                    // 시작 인덱스 반환, i - (m - 1) + 1
                    matchIdx.add(i - m + 2);
                    j = pi[j];
                    continue;
                }
                j++;
            }
        }
        return false;
    }

}