
import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        Node[] child = new Node[26];
        boolean end = false;
    }

    static Node root = new Node();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            insert(s);
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (find(s)) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean find(String s) {
        Node cur = root;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (cur.child[x] == null) return false;
            cur = cur.child[x];
        }
        return true;
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
}
