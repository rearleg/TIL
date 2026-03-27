import java.util.*;
import java.io.*;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int size = 1;
        while (size < N) size <<= 1;

        tree = new long[size * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[size + i] = Integer.parseInt(st.nextToken());
        }

        setTree(size);
//        System.out.println(Arrays.toString(tree));

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x < y) System.out.println(query(x, y, size));
            else System.out.println(query(y, x, size));

            update(a, b, size);;
//            System.out.println(Arrays.toString(tree));
        }

    }
    static long sum(long a, long b) {
        return a + b;
    }

    static void setTree(int size) {
        for (int idx = size - 1; idx > 0; idx--) {
            int l = idx * 2;
            int r = idx * 2 + 1;
            tree[idx] = sum(tree[l], tree[r]);
        }
    }

    static long query(int l, int r, int size) {

        l += size - 1;
        r += size - 1;

        long res = 0;
        while (l <= r) {
            if (l % 2 == 1) res = sum(res, tree[l++]);
            if (r % 2 == 0) res = sum(res, tree[r--]);

            l /= 2;
            r /= 2;
        }

        return res;

    }

    static void update(int idx, int value, int size) {
        int node = idx + size - 1;

        tree[node] = value;
        node /= 2;
        while (node > 0) {
            int l = node * 2;
            int r = node * 2 + 1;
//            System.out.println("l = " + l + " r = " + r);

            tree[node] = sum(tree[l], tree[r]);
            node /= 2;
        }

    }
}

