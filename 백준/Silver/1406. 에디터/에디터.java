import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < init.length(); i++) list.add(init.charAt(i));

        // 커서를 가리키는 iterator: 초기 커서는 맨 뒤
        ListIterator<Character> it = list.listIterator(list.size());

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            char cmd = line.charAt(0);

            if (cmd == 'L') {
                if (it.hasPrevious()) it.previous();
            } else if (cmd == 'D') {
                if (it.hasNext()) it.next();
            } else if (cmd == 'B') {
                if (it.hasPrevious()) {
                    it.previous(); // 삭제할 문자로 이동
                    it.remove();   // 방금 previous/next로 가리킨 원소 삭제
                }
            } else if (cmd == 'P') {
                char x = line.charAt(2);
                it.add(x); // 커서 위치에 삽입 (커서는 삽입 문자 뒤에 위치)
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : list) sb.append(ch);
        System.out.print(sb);
    }
}