import java.util.*;
import java.io.*;

public class Solution {

    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static ArrayList<Integer>[] edges;
    static int[] max;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            dist = new int[101];
            Arrays.fill(dist, INF);
            edges = new ArrayList[101];
            for (int i = 1; i <= 100; i++) edges[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N/2; i++) {
//                System.out.println(i);
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edges[from].add(to);
            }

            max = new int[] {-1, -1};
            dijk(s);
            System.out.println("#" + tc + " " + max[0]);
        }
    }
    static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] {start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (dist[now] < cost) continue;

            for (int next : edges[now]) {
                int newCost = cost + 1;
                if (dist[next] > newCost) {
                    dist[next] = newCost;
                    pq.offer(new int[] {next, newCost});

                    if (max[1] < newCost || (max[1] == newCost && max[0] < next)) {
                        max[0] = next;
                        max[1] = newCost;
                    }

                }
            }
        }

    }

}
