
import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        Node[] child = new Node[26];
        boolean end = false;
        Node fail;
    }

    static Node root = new Node();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            insert(br.readLine());
        }

        aho();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            System.out.println(find(br.readLine()) ? "YES" : "NO");
        }
    }

    static boolean find(String s) {
        Node cur = root;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';

            while(cur != root && cur.child[x] == null) cur = cur.fail;

            if (cur.child[x] != null) {
                cur = cur.child[x];
            }

            if (cur.end) return true;
        }

        return false;
    }

    static void insert(String s) {
        Node cur = root;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (cur.child[x] == null) cur.child[x] = new Node();

            cur = cur.child[x];
        }

        cur.end = true;
    }

    static void aho() {
        Queue<Node> q = new ArrayDeque<>();

        root.fail = root;
        q.offer(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 26; i++) {
                Node next = cur.child[i];
                if (next == null) continue;

                if (cur == root) next.fail = root;
                else {
                    Node dest = cur.fail;

                    while (dest != root && dest.child[i] == null) {
                        dest = dest.fail;
                    }

                    if (dest.child[i] != null) dest =dest.child[i];

                    next.fail = dest;
                }

                if (next.fail.end) {
                    next.end = true;
                }

                q.offer(next);
            }
        }
    }
}
