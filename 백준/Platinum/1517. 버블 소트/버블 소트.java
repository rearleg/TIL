import java.util.*;
import java.io.*;

class Main{
    static int maxOrder = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 배열
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 좌표 압축
        int[] compArr = comp(arr);

        // 세그트리
        int size = Integer.highestOneBit(n);
        if (size < n) size <<= 1;

        long[] tree = new long[size * 2];
        long ans = 0;
        for (int i = 0 ; i< n; i++) {
            int x = compArr[i];
            ans += query(x+1, maxOrder, tree, size);

            update(x, tree, size);
        }

        System.out.println(ans);

    }

    static long query(int start, int end, long[] tree, int size) {
        int startIdx = start + size - 1;
        int endIdx = end + size - 1;
        long sum = 0;

        while (startIdx <= endIdx) {
            if(startIdx % 2 == 1) sum += tree[startIdx++];
            if(endIdx % 2 == 0) sum += tree[endIdx--];
            startIdx /= 2;
            endIdx /= 2;
        }

        return sum;
    }

    static void update(int x, long[] tree, int size) {
        int idx = x + size - 1;
        tree[idx]++;

        while (idx > 0) {
            idx /= 2;
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
        }
    }

    // 좌표 압축
    static int[] comp(int[] arr) {
        int n = arr.length;
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        Map<Integer, Integer> map = new HashMap<>();
        int order = 1;

        for (int x : tmp) {
            if (!map.containsKey(x)) {
                map.put(x, order++);
            }
        }

        maxOrder = order - 1;

        for (int i = 0; i < n; i++) {
            tmp[i] = map.get(arr[i]);
        }


        return tmp;
    }
}