import java.util.*;

class Solution {
    
    static List<Integer>[] tree;
    static int[][] dp;  // 0=불참, 1=참
    static int[] salesArr;

    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        
        salesArr = sales;
        tree = new ArrayList[n+1];
        dp = new int[n + 1][2];
        
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] link : links) {
            int parent = link[0];
            int child = link[1];
            tree[parent].add(child);
        }
        
        dfs(1);
        
        // for (int i = 1; i <= n; i++) {
        //     System.out.print(i + " " + dp[i][0] + " " + dp[i][1]);
        //     System.out.println();
        // }
        
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    static void dfs(int cur) {
        dp[cur][1] = salesArr[cur - 1];
        
        // 리프 노드일 경우
        if (tree[cur].isEmpty()) {
            dp[cur][0] = 0;
            return;
        }
        
        int sum = 0;
        int extra = Integer.MAX_VALUE;
        boolean hasAttendChild = false;
        
        for (int child : tree[cur]) {
            dfs(child);
            
            if (dp[child][0] < dp[child][1]) {
                sum += dp[child][0];
                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            } else {
                sum += dp[child][1];
                hasAttendChild = true;
                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            }
            
        }
        
        dp[cur][1] += sum;
        
        if (hasAttendChild) {
            dp[cur][0] = sum;
        } else {
            dp[cur][0] = sum + extra;
        }
        
    }
}