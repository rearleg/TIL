import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        String ans = "ZZZ";

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        // 순회하며 최고값 찾기
        int temp = 0;
        // 엔트리셋 to 엔트리 for each문으로 순회 O(n)
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > temp) {
                ans = e.getKey();
                // 최고 갱신
                temp = e.getValue();
            } else if (e.getValue() == temp && ans.compareTo(e.getKey()) > 0) {
                ans = e.getKey();
            }
        }

        System.out.println(ans);


    }
}

