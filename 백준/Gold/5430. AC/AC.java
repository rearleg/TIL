import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static String solution(String cmd, int n, Deque<Integer> arr) {

        boolean direction = true;
        StringBuilder sb = new StringBuilder();

        for (char ch : cmd.toCharArray()) {
            if (ch == 'R') {
                if(direction) direction = false;
                else direction = true;
            }

            if (ch == 'D') {
                if (arr.isEmpty()) return "error";

                if(direction) {
                    arr.removeFirst();
                } else {
                    arr.removeLast();
                }
            }
        }

        int size = arr.size();
        for (int i = 0; i < size; i++) {
            if (direction) {
                if (i == size-1) {
                    sb.append(String.valueOf(arr.removeFirst()));
                } else {
                    sb.append(String.valueOf(arr.removeFirst())).append(",");
                }
            } else {
                if (i == size-1) {
                    sb.append(String.valueOf(arr.removeLast()));
                } else {
                    sb.append(String.valueOf(arr.removeLast())).append(",");
                }
            }

        }



        return "["+sb+"]";
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            // cmd 받기
            String cmd = br.readLine();
            // n 받기
            int n = Integer.parseInt(br.readLine());
            // arr 배열 만들기
            Deque<Integer> arr = new ArrayDeque<>();
            // 포맷에 맞게 배열 받기
            String input = br.readLine().replace("[", "").replace("]", "").replace(",", " ");
            String[] inputArr = input.split(" ");
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(inputArr[i]);
                arr.add(x);

            }
            String answer =  solution(cmd, n, arr);
            System.out.println(answer);

        }
    }
}
