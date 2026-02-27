import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] right = new int[26];
    static int[] left = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(right, -1);
        Arrays.fill(left, -1);

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[7][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            int pi = p - 'A';
            if (l != '.') left[pi] = l - 'A';
            if (r != '.') right[pi] = r - 'A';




        }
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);


        System.out.println(sb.toString());
    }

    // 전위
    static void preorder(int s) {
        if(s == -1) return;
        sb.append((char) (s + 'A'));
        preorder(left[s]);
        preorder((right[s]));
    }

    // 중위
    static void inorder(int s) {
        if(s == -1) return;
        inorder(left[s]);
        sb.append((char) (s + 'A'));
        inorder((right[s]));
    }

    // 후위
    static void postorder(int s) {
        if(s == -1) return;
        postorder(left[s]);
        postorder((right[s]));
        sb.append((char) (s + 'A'));
    }

}