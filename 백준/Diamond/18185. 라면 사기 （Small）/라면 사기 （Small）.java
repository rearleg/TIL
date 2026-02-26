// 배운점 - 멀티소스다익스트라
import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cost = 0;

        for (int i = 0; i < n; i++) {
            int v = 0;
            if (arr[i+1] > arr[i+2]) {
                // 2개 먼저 구매
                v = Math.min(arr[i], arr[i+1] - arr[i+2]);
                cost += v * 5;
                arr[i] -= v;
                arr[i+1] -= v;

                // 그 다음 3개 구매
                v = Math.min(arr[i], Math.min(arr[i+1], arr[i+2]));
                cost += v * 7;
                arr[i] -= v;
                arr[i+1] -= v;
                arr[i+2] -= v;

                // 나머지 1개 구매
                v = arr[i];
                cost += v * 3;
                arr[i] -= v;
            } else {
                // 나머지 경우에서는 3개씩 구매
                v = Math.min(arr[i], Math.min(arr[i+1], arr[i+2]));
                cost += v * 7;
                arr[i] -= v;
                arr[i+1] -= v;
                arr[i+2] -= v;

                v = Math.min(arr[i], arr[i+1]);
                cost += v * 5;
                arr[i] -= v;
                arr[i+1] -= v;

                v = arr[i];
                cost += v * 3;
                arr[i] -= v;
            }
        }
        System.out.println(cost);


    }
}