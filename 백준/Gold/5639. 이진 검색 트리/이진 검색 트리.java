import java.util.*;
import java.io.*;

class Main {
    static List<List<int[]>> graph;
    static int max;
    static int N;
    static int[] pre;
    static int n = 0;
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pre = new int[100000];
        String line;

        while ((line = br.readLine()) != null &&!line.isEmpty()) {
            pre[n] = Integer.parseInt(line.trim());
            n++;
        }

        postorder(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(sb.toString());

    }
    static void postorder(int low, int high) {
        if (idx >= n) return;

        int val = pre[idx];
        if (val <= low || val >= high) return;

        idx++;
        postorder(low, val); // left
        postorder(val, high); // right
        sb.append(val).append('\n');
    }
}