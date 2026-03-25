import java.util.*;
import java.io.*;

public class Main {

    static int[] heap;
    static int size = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        heap = new int[N+1];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) offer(x);
            else sb.append(poll()).append("\n");
        }
        System.out.println(sb.toString());

    }

    static void offer(int x) {
        int idx = ++size;
        heap[idx] = x;

        while (idx > 1) {
            int parent = idx / 2;

            if (heap[parent] >= heap[idx]) break;

            int tmp = heap[idx];
            heap[idx] = heap[parent];
            heap[parent] = tmp;

            idx = parent;
        }
//        System.out.println(Arrays.toString(heap));
    }

    static int poll() {
        if (size == 0) return 0;

        int num = heap[1];

        heap[1] = heap[size];
        size--;

        int idx = 1;

        while (true) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int biggest = idx;

            if (left <= size && heap[left] > heap[biggest]) biggest = left;
            if (right <= size && heap[right] > heap[biggest]) biggest = right;

            if (biggest == idx) break;

            int temp = heap[idx];
            heap[idx] = heap[biggest];
            heap[biggest] = temp;

            idx = biggest;
        }
//        System.out.println(Arrays.toString(heap));
        return num;
    }

}
