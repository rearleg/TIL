import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] tree;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int size = Integer.highestOneBit(N);
        if (size < N) size <<= 1;

        arr = new int[N+1];
        tree = new int[size * 2];
        Arrays.fill(tree, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tree[size+i-1] = i;
        }

        setTree(size);

        M = Integer.parseInt(br.readLine());


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (cmd == 1) update(x, y, size);
            else System.out.println(query(x, y, size));
        }
    }

    // better
    static int better(int a, int b) {
        if (a == -1) return b;
        if (b == -1) return a;

        if (arr[a] < arr[b]) return a;
        if (arr[a] > arr[b]) return b;
        return Math.min(a, b);
    }

    // setTree
    static void setTree(int size) {

        for (int idx = size - 1; idx > 0; idx--) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            tree[idx] = better(tree[left], tree[right]);
        }
//        System.out.println(Arrays.toString(tree));

    }
    // update
    static void update(int idx, int v, int size) {
        arr[idx] = v;

        int node = idx - 1 + size;
        tree[node] = idx;
        node /= 2;
        while (node > 0) {

            tree[node] = better(tree[node * 2], tree[node * 2 + 1]);
            node /= 2;
        }

    }

    // query
    static int query(int l, int r, int size) {

        l += size - 1;
        r += size - 1;

        int leftSelect = -1;
        int rightSelect = -1;

        while (l <= r) {
            if (l % 2 == 1) leftSelect = better(leftSelect, tree[l++]);
            if (r % 2 == 0) rightSelect = better(tree[r--], rightSelect);

            r /= 2;
            l /= 2;
        }
        return better(leftSelect, rightSelect);
    }
}

/*
    🌙
  ／|、
（ﾟ､ ｡ ７
  |、 ~ヽ
  じしf_,)ノ
 */