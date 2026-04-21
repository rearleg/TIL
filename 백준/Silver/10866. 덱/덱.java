import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (cmd.equals("push_front")) {
                    deque.addFirst(n);
                } else {
                    deque.addLast(n);
                }
            } else {
                if (cmd.equals("pop_front")) System.out.println(deque.isEmpty() ? -1 : deque.removeFirst());
                else if (cmd.equals("pop_back")) System.out.println(deque.isEmpty() ? -1 : deque.removeLast());
                else if (cmd.equals("size")) System.out.println(deque.size());
                else if (cmd.equals("empty")) System.out.println(deque.isEmpty() ? 1 : 0);
                else if (cmd.equals("front")) System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                else System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
            }
        }

    }
}
