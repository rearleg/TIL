import java.util.*;
import java.io.*;

public class Main {
    static int[] answer;
    static int cnt = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // visited 만들기
        boolean[] visited = new boolean[n+1];
        // answer 만들기
        answer = new int[n+1];

        // list 만들기
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        // 인접 리스트 만들기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            arr.get(y).add(x);
        }

        // 정렬
        for (int i = 1; i < n+1; i++) {
            Collections.sort(arr.get(i));
        }
        // dfs
        dfs(k, arr, visited);

        // 출력
        for (int i = 1; i < n + 1; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int s, List<List<Integer>> arr, boolean[] visited) {
        visited[s] = true;
        answer[s] = cnt++;

        for (int next : arr.get(s)) {
            if (!visited[next]) {
                dfs(next, arr, visited);
            }
        }
    }
}