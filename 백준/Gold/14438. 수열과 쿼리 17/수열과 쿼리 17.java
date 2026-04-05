import java.util.*;
import java.io.*;

public class Main {

    static int[] tree;
    static int[] arr;

    static final int MAX = 100_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new int[4 * N + 1];

        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        build(1, 1, N);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());



            if (a == 1){
                update(1, 1, N, b, c);
            }
            else {
                System.out.println(query(1, 1, N, b, c));
            }
        }

    }

    static int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return Integer.MAX_VALUE;

        // 완전히 포함?
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        int minL = query(node*2, start, mid, left, right);
        int minR = query(node*2+1, mid+1, end, left, right);

        return Math.min(minL,minR);
    }

    static void update(int node, int start, int end, int idx, int value) {
        if (idx < start || end < idx) return;

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        update(node*2, start, mid, idx, value);
        update(node*2+1, mid+1, end, idx, value);

        tree[node] = Math.min(tree[node*2], tree[node*2+1]);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node*2, start, mid);
        build(node*2+1, mid+1, end);

        tree[node] = Math.min(tree[node*2], tree[node*2+1]);
    }
}
