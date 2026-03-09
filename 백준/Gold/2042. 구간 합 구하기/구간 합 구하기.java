import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // set arr
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());

        // set tree
        int size = getSize(N);
        long[] tree = setTree(N, arr, size);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                tree = updateTree(b, c, tree, size);
            }
            else {
                System.out.println(getValue(b, (int) c, tree, size));
            }
        }
    }

    static long[] setTree(int n, long[] arr, int size) {
        long[] tree = new long[size * 2];

        // 리프 채우기
        for (int i = 0; i < n; i++) {
            tree[size+i] = arr[i];
        }

        // 부모 채우기
        for (int i = size - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
        return tree;
    }

    static int getSize(int n) {
        int size = Integer.highestOneBit(n);
        if (size < n) size <<= 1;
        return size;
    }

    static long[] updateTree(int target, long n, long[] tree, int size) {
        int idx = target + size - 1;
        long diff = n - tree[idx];

        while (idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }

        return tree;
    }

    static long getValue(int start, int end, long[] tree, int size) {
        long sum = 0;

        int startIdx = start + size - 1;
        int endIdx = end + size - 1;

        while (startIdx <= endIdx) {
            sum += startIdx % 2 == 1 ? tree[startIdx] : 0;
            sum += endIdx % 2 == 0 ? tree[endIdx] : 0;

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return sum;
    }
}

