import java.util.*;
import java.io.*;

public class Solution {

    static char[] left;
    static char[] right;
    static char[] node;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            left = new char[n+1];
            right = new char[n+1];
            node = new char[n+1];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char p = st.nextToken().charAt(0);
                char l = st.nextToken().charAt(0);
                char r = st.nextToken().charAt(0);

                node[idx] = p;
                if(l != '0') left[idx] = l;
                if(r != '0') right[idx] = r;
            }

//            System.out.println(Arrays.toString(node));
            int result = inorder(0, 1);
            System.out.println("#" + tc + " " + result);
        }
    }

    static int inorder(int sum, int s) {
        if (s == 0) return 0;

        char cur = node[s];

        if (Character.isDigit(cur)) return cur - '0';

        int a = inorder(sum, left[s] - '0');
        int b = inorder(sum, right[s] - '0');
//        System.out.println("a = " + a + " b = " + b);

        if (cur == '+') sum += a + b;
        else if (cur == '-') sum += a - b;
        else if (cur == '*') sum += a * b;
        else sum += a / b;

        return sum;
    }
}
