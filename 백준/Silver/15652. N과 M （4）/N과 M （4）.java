import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(n, m, 1, 0, new ArrayList<>());

        System.out.println(sb.toString());

    }

    static void dfs(int n, int m, int s, int d, List<Integer> arr) {

        if (d == m ) {
            for (int i = 0; i < m; i++) {
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = s; i <= n; i++) {
            arr.add(i);
            dfs(n, m, i, d+1, arr);
            arr.remove(arr.size()-1);
        }

    }

}