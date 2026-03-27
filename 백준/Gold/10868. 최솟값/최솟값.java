import java.util.*;
import java.io.*;

public class Main {

    static int[] tree;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int size = 1;
        while (size < N) size <<= 1;

        tree = new int[size * 2];
        Arrays.fill(tree, INF);

        for (int i = 0; i < N; i++) {
            tree[size + i] = Integer.parseInt(br.readLine());
        }

        setTree(size);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(query(a, b, size));
        }
    }

    static int better(int a, int b) {
        return Math.min(a, b);
    }

    static void setTree(int size) {
        for (int idx = size - 1; idx > 0; idx--) {
            int l = idx * 2;
            int r = idx * 2 + 1;
            tree[idx] = better(tree[l], tree[r]);
        }

//        System.out.println(Arrays.toString(tree));
    }

    static int query(int l, int r, int size) {

        l += size - 1;
        r += size - 1;

        int res = INF;
        while (l <= r) {
//            System.out.println("l = " + l + "(" + tree[l] + ") r = " + r + "(" + tree[r] + ")");
            if (l % 2 == 1) res = better(res, tree[l++]);
            if (r % 2 == 0) res = better(res, tree[r--]);

            l /= 2;
            r /= 2;
        }

        return res;
    }
}

