import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 배열 받기
            char[][] flag = new char[n][m];
            int[][] colorCnt = new int[n][3];   // 최소 갯수를 알기 위해!
            for (int i = 0; i< n; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j <m ; j++) {
                    flag[i][j] = s.charAt(j);
                    if (flag[i][j] == 'W') colorCnt[i][0]++;
                    if (flag[i][j] == 'B') colorCnt[i][1]++;
                    if (flag[i][j] == 'R') colorCnt[i][2]++;
                }
            }

//            for (int i = 0; i < n; i++) System.out.println(Arrays.toString(colorCnt[i]));

            int ans = motherRussia(n, m, colorCnt);
            System.out.println("#" + tc + " " + ans);
        }
    }
    
    // 완탐
    static int motherRussia(int n, int m, int[][] colorCnt) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n - 1; j++) {

                int cost = 0;

                // W구간 경우
                for (int k = 0; k <= i; k++) {
                    cost += m - colorCnt[k][0];;
                }
                
                // B구간
                for (int k = i+1; k <= j; k++) {
                    cost += m - colorCnt[k][1];
                }
                
                // R구간
                for (int k = j + 1; k < n; k++) {
                    cost += m - colorCnt[k][2];
                }

                ans = Math.min(ans, cost);
            }
        }
        return ans;
    }

}