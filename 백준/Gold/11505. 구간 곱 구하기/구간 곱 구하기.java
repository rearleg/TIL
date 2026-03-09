import java.util.*;
import java.io.*;

public class Main {
    static long mod = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // arr
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        // tree
        int size = Integer.highestOneBit(N);
        if (size < N) size <<= 1;
        long[] tree = new long[size * 2];
        Arrays.fill(tree, 1);
        setTree(N, size, tree, arr);

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if (a == 1) update(b, c, size, tree);
            else System.out.println(getValue(b, (int)c, size, tree));
        }

    }

    static long getValue(int a, int b, int size, long[] tree) {
        int startIdx = a + size - 1;
        int endIdx = b + size - 1;
        long multi = 1;

        while(startIdx <= endIdx) {
            multi = (multi * (startIdx % 2 == 1 ? tree[startIdx] : 1)) % mod;
            multi = (multi * (endIdx % 2 == 0 ? tree[endIdx] : 1)) % mod;

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        return multi;
    }

    static void update(int target, long num, int size, long[] tree) {
        int idx = target + size - 1;
        tree[idx] = num;
        idx /= 2;
        while (idx > 0) {
            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % mod;
            idx /= 2;
        }
    }

    static void setTree(int N, int size, long[] tree, long[] arr) {

        for (int i = 0; i < N; i++) {
            tree[size+i] = arr[i];
        }

        int idx = size - 1;
        while (idx > 0) {
            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % mod;
            idx--;
        }
    }
}

