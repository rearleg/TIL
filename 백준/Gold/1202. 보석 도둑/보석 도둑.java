import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bags = new int[K];
        for (int i = 0 ; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            int bag = bags[i];

            while (idx < N && jewels[idx][0] <= bag) {
                pq.add(jewels[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }


        System.out.println(sum);

    }
}

