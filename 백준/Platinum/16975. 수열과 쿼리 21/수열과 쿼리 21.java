import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static long[] arr;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int size = 1;
        while (size < N) size <<= 1;

        tree = new long[size * 2];
        lazy = new long[size * 2];

        init(1, 1, N);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long k = Integer.parseInt(st.nextToken());
                update(1, 1, N, a, b, k);
            }
            else {
                int x = Integer.parseInt(st.nextToken());
                System.out.println(query(1, 1, N, x));
            }
        }

    }

    // init
    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    // push -> lazy를 내려주는 역할
    static void push(int node, int start, int end) {

        if (lazy[node] == 0) return;

        tree[node] += (end - start + 1) * lazy[node];

        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }

        lazy[node] = 0;

    }

    // update

    static void update(int node, int start, int end, int left, int right, long diff) {

        push(node, start, end);

        // 겹치는 경우가 없는 경우
        if (right < start || end < left) return;

        // 전체가 포함되는 경우
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;

            // 자식에게 미루기
            if (end != start) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }

            return;
        }

        // 일부 포함되는 경우
        int mid = (start + end) / 2;

        update(node * 2, start, mid, left, right, diff);
        update(node * 2 + 1, mid + 1, end, left, right, diff);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }

    // query
    static long query(int node, int start, int end, int x) {
        push(node, start, end);

        if (start == end) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        if (x <= mid) return query(node * 2, start, mid, x);
        else return query(node * 2 + 1, mid + 1, end, x);


    }

}

