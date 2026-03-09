import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int size = getSize(N);

        int[] maxTree = new int[size*2];
        int[] minTree = new int[size*2];
        Arrays.fill(minTree, INF);
        setMaxTree(N, size, maxTree, arr);
        setMinTree(N, size, minTree, arr);
        
//        System.out.println(Arrays.toString(maxTree));
//        System.out.println(Arrays.toString(minTree));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(getMinValue(a, b, minTree, size) + " " + getMaxValue(a, b, maxTree, size));
        }

    }

    static int getMinValue(int a, int b, int[] tree, int size) {
        int startIdx = a + size - 1;
        int endIdx = b + size - 1;
        int min = INF;
        while (startIdx <= endIdx) {
            min = Math.min(startIdx % 2 == 1 ? tree[startIdx] : INF, min);
            min = Math.min(endIdx % 2 == 0 ? tree[endIdx] : INF, min);

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        return min;
    }

    static int getMaxValue(int a, int b, int[] tree, int size) {
        int startIdx = a + size - 1;
        int endIdx = b + size - 1;
        int max = 0;
        while (startIdx <= endIdx) {
            max = Math.max(startIdx % 2 == 1 ? tree[startIdx] : 0, max);
            max = Math.max(endIdx % 2 == 0 ? tree[endIdx] : 0, max);

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }
        return max;
    }

    static void setMaxTree(int n, int size, int[] tree, int[] arr) {
        // 리프 노드 업데이트
        for (int i = 0; i < n; i++) {
            tree[size+i] = arr[i];
        }

        // 부모 노드 업데이트
        int idx = size - 1;
        while (idx > 0) {
            tree[idx] = Math.max(tree[idx * 2], tree[idx * 2 + 1]);
            idx--;
        }

    }
    static void setMinTree(int n, int size, int[] tree, int[] arr) {
        for (int i = 0; i < n; i++) {
            tree[size+i] = arr[i];
        }

        int idx = size - 1;
        while (idx > 0) {
            tree[idx] = Math.min(tree[idx * 2], tree[idx * 2 + 1]);
            idx--;
        }


    }

    static int getSize(int n) {
        int size = Integer.highestOneBit(n);
        if (size < n) size <<= 1;

        return size;
    }
}

