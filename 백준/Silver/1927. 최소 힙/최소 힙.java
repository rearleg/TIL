import java.util.*;
import java.io.*;

public class Main {

    static int[] heap;
    static int size = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int size = Integer.highestOneBit(N);
        if (size < N) size <<= 1;

        heap = new int[size];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) offer(x);
            else System.out.println(poll());
        }

    }

    static void offer(int x) {
        heap[++size] = x;

        int idx = size;

        while (idx > 1) {
            int parent = idx / 2;

            if (heap[parent] <= heap[idx]) break;

            int temp = heap[parent];
            heap[parent] = heap[idx];
            heap[idx] = temp;

            idx = parent;
        }
    }

    static int poll() {
        if (size == 0) return 0;

        int min = heap[1];

        heap[1] = heap[size--];

        int idx = 1;

        while (true) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int smallest = idx;

            if (left <= size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right <= size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            if (smallest == idx) break;

            int temp = heap[idx];
            heap[idx] = heap[smallest];
            heap[smallest] = temp;

            idx = smallest;
        }

        return min;
    }

}
