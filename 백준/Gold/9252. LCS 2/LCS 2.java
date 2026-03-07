import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = br.readLine().toCharArray();  //row
        int n = arr1.length;
        char[] arr2 = br.readLine().toCharArray();  //column
        int m = arr2.length;
        int[][] dp = new int[n][m];

        if (arr1[0] == arr2[0]) dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            if (arr1[i] == arr2[0] && dp[i][0] != 1) dp[i][0] = 1;
            else dp[i][0] = dp[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            if (arr2[i] == arr1[0]) dp[0][i] = 1;
            else dp[0][i] = dp[0][i-1];

        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

//        for (int i = 0 ; i < arr1.length; i++) System.out.println(Arrays.toString(dp[i]));
        System.out.println(dp[n-1][m-1]);

        int i = n - 1;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            if (arr1[i] == arr2[j]) {
                sb.append(arr1[i]);
                i--;
                j--;
            } else {
                if (i > 0 && j > 0) {
                    if (dp[i - 1][j] >= dp[i][j - 1]) i--;
                    else j--;
                } else if (i > 0) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
