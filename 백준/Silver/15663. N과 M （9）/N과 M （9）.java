import java.util.*;
import java.io.*;

class Main {
    static Set<List<Integer>> ans;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        ans = new TreeSet<>((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!Objects.equals(a.get(i), b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        dfs(m, arr, new ArrayList<>());

        for (List<Integer> a : ans) {
            for (int val : a) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int m, List<Integer> arr, List<Integer> tmp) {
        if (tmp.size() == m) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (visited[i]) continue; // 이미 사용한 인덱스 건너뛰기

            visited[i] = true;
            tmp.add(arr.get(i));
            dfs(m, arr, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}