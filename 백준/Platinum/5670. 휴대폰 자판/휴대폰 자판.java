import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        Node[] child = new Node[26];
        boolean end = false;
        int size = 0;
    }

    static Node root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            root = new Node();

            int N = Integer.parseInt(line);
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                insert(s);
                arr[i] = s;
            }
            double sum = 0.0;
            for (int i = 0; i < arr.length; i++) {
                sum += typing(arr[i]);
            }

            System.out.printf("%.2f\n", sum / N);

        }
    }

    static double typing(String s) {
        Node cur = root.child[s.charAt(0) - 'a'];
        int n = s.length();
        double cnt = 1;

        // 사이즈가 1이면 cnt X
        // 사이즈가 1이상이면 cnt++
        // 첫 입력은 무조건 cnt++


        for (int i = 1; i < n; i++) {
            if (cur.size > 1 || cur.end) cnt++;
            int idx = s.charAt(i) - 'a';
            cur = cur.child[idx];
        }
//        if (cur.size == 0) cnt++;
//        System.out.println(cnt);

        return cnt;
    }

    static void insert(String s) {
        Node cur = root;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
                cur.size++;
            }

            cur = cur.child[idx];
        }
        cur.end = true;
    }
}
