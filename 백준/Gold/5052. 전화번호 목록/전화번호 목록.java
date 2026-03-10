import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        Node[] child = new Node[10];
        boolean end = false;
    }

    static Node root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        next:
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            root = new Node();

            String[] arr= new String[n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                arr[i] = s;

                insert(s);
            }

            for (String s : arr) {
                if (!search(s)) {
                    System.out.println("NO");
                    continue next;
                }
            }

            System.out.println("YES");

        }

    }

    static boolean search(String s) {
        Node cur = root;

        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - '0';
            if (cur.child[idx] == null) return false;
            if (cur.end) return false;
            cur = cur.child[idx];
        }

        return true;
    }

    static void insert(String s){
        Node cur = root;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }
        cur.end = true;
    }

}

