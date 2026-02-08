
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        if (KMP(s,p)) System.out.println(1);
        else System.out.println(0);

    }

    static int[] buildPi(String p) {
        int n = p.length();
        int[] pi = new int[n];
        
        for (int i = 1, j = 0; i < n; i++) {
            
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
        
    }



    static boolean KMP(String s, String p) {
        int n = s.length();
        int m = p.length();

        // 0이라면 일치로 판정
        if (m==0) return true;

        int[] pi = buildPi(p);

        // 문자열 패턴 매칭
        for (int i = 0, j = 0; i < n; i++) {

            // 불일치 처리
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            // 일치 처리
            if (s.charAt(i) == p.charAt(j)) {
                // 끝에 도달한다면, 일치
                if (j == m - 1) return true;

                j++;
            }
        }
        return false;
    }
}