import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    static Node root = new Node();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            insert(br.readLine());
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            if (search((br.readLine()))) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    static boolean search(String s) {
        Node cur = root;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (cur.child[idx] == null) {
                return false;
            }
            cur = cur.child[idx];
        }
        return cur.end;
    }

    static void insert(String s) {
        Node cur = root;

        for (int i = 0; i< s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }
        cur.end = true;
    }

}

