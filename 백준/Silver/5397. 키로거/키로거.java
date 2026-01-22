/*
1. 스택 2개 사용
- 일반 입력값은 스택1에 차곡차곡 넣음
- 방향키 커서가 지나온 곳에 있는 것은 스택2에 옮겨 놓음
- 방향키가 다시 반대로 움직이면 스택2에서 스택1로 옮김
- 백스페이스는 스택1에 있는 거 pop
 */

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static String keyLoger(String cmd) {
        Stack<Character> password = new Stack<>();
        Stack<Character> tempPassword = new Stack<>();

        for (char ch : cmd.toCharArray()) {
            if (ch == '<') {
                if (!password.isEmpty()) tempPassword.add(password.pop());
            } else if (ch == '>') {
                if (!tempPassword.isEmpty()) password.add(tempPassword.pop());
            } else if (ch == '-') {
                if (!password.isEmpty()) password.pop();
            } else {
                password.add(ch);
            }
        }

        if (!tempPassword.isEmpty()) {
            while (!tempPassword.isEmpty()) {
                password.add(tempPassword.pop());
            }
        }

        String ans = password.stream().map(Objects::toString).collect(Collectors.joining(""));
        return ans;
    }



    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String cmd = br.readLine();

            String result = keyLoger(cmd);
            System.out.println(result);
        }


    }
}

