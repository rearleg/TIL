import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(n, m, 1, 0, new ArrayList<>());

    }

    static void dfs(int n, int m, int s, int d, List<Integer> arr) {
        if (d == m) {
            System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = s ; i <= n; i++) {
            arr.add(i);
            dfs(n, m, i+1, d+1, arr);
            arr.remove(arr.size()-1);
        }

    }

}