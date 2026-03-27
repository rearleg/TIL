
import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        int size = 1;
        while (size < N) size <<= 1;

        tree = new int[size * 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        init(1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
                update(1, 1, N, a);
            }
            else {
                System.out.println(tree[1]);
            }
        }

    }

    static int better(int a, int b) {
        if (arr[a] < arr[b]) return a;
        if (arr[b] < arr[a]) return b;
        return Math.min(a, b);
    }

    static void init(int node, int start, int end) {

        if (start == end) {
            tree[node] = start;
            return;
        }

        int mid = (end + start) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid+1, end);

        tree[node] = better(tree[node * 2], tree[node * 2 + 1]);
    }

    static void update(int node, int start, int end, int idx) {
        if (idx < start || end < idx) return;

        if (start == end) {
            tree[node] = start;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx);
        update(node * 2 + 1, mid+1, end, idx);

        tree[node] = better(tree[node * 2], tree[node * 2 + 1]);
    }

//    static int query(int node, int start, int end, int left, int right) {
//        if (right < start || end < left) return 0;
//        if (left <= start && end <= right) return tree[node];
//
//        int mid = (end + start) / 2;
//        int l = query(node * 2, start, mid, left, right);
//        int r = query(node * 2 + 1, mid+1, end, left, right);
//
//        return better(l, r);
//    }
}
