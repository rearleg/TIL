import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        
        int answer = bfs(n, adj);
        return answer;
    }
    
    static int bfs(int n, List<List<Integer>> adj) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        int cnt = 0;
        int max = 0;
        
        q.offer(new int[] {1, 0});
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int dist = cur[1];
            
            if (max < dist) {
                max = dist;
                cnt = 1;
            }
            else if (max == dist) cnt++;
            
            for (int x : adj.get(now)) {
                if (visited[x]) continue;
                q.offer(new int[] {x, dist+1});
                
                visited[x] = true;
            }
        }
        return cnt;
        
    }
}