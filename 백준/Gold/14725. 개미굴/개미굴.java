import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        Map<String, Node> child = new TreeMap<>();
    }

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Node root = new Node();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            insert(k);
        }

        dfs(root, 0);

        System.out.println(sb.toString());
    }

    static void insert(int k) {
        Node cur = root;

        for (int i = 0 ; i < k; i++) {
            String s = st.nextToken();

            if (!cur.child.containsKey(s)) {
                cur.child.put(s, new Node());
            }
            cur = cur.child.get(s);
        }
    }

    static void dfs(Node node, int depth) {

        for (String s : node.child.keySet()) {

            for (int i = 0; i < depth; i++) sb.append("--");

            sb.append(s).append("\n");

            dfs(node.child.get(s), depth + 1);
        }
    }
}
