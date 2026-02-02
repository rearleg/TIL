import java.util.*;
import java.io.*;


class Solution {
    public static int solution(int n, int[][] results) {
        List<List<Integer>> winArr = new ArrayList<>();
        List<List<Integer>> loseArr = new ArrayList<>();

        int answer = 0;
        // 인접리스트 만들기 (지는 경우 + 이기는 경우)
        for (int i = 0; i <= n; i++) {
            winArr.add(new ArrayList<>());
            loseArr.add(new ArrayList<>());
        }
        for (int i = 0; i < results.length; i++) {
            int x = results[i][0], y = results[i][1];
            winArr.get(x).add(y);
            loseArr.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            int winCnt = bfs(i, winArr, n);
            int loseCnt = bfs(i, loseArr, n);
            if (winCnt + loseCnt == n - 1) answer++;
        }

        return answer;
    }

    public static int bfs(int s, List<List<Integer>> results, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int next : results.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void main(String[] args) throws IOException {
        int n = 5;
        int[][] results = {{4, 3}, {4,2}, {3,2}, {1,2}, {2,5}};
        int result = solution(n, results);
        System.out.println(result);
    }
}