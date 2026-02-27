import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                sb.append(ch);
            } else if (ch == '(') {
                dq.push(ch);
            } else if (ch == ')') {
                while (!dq.isEmpty() && dq.peek() != '(') {
                    sb.append(dq.pop());
                }
                dq.pop();
            } else {
                while (!dq.isEmpty() && prec(dq.peek()) >= prec(ch)) {
                    if (dq.peek() == '(') break;
                    sb.append(dq.pop());
                }
                dq.push(ch);
            }
        }

        while (!dq.isEmpty()) sb.append(dq.pop());
        System.out.println(sb.toString());

    }

    static int prec(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }
}