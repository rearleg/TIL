
import java.io.*;
import java.util.*;

class Solution {
    static Deque<String> answer = new ArrayDeque<>();
    static Map<String, List<String>> map = new HashMap<>();
    public static String[] solution(String[][] tickets) {
        // 인접리스트로 변환
        int n = tickets.length;

        // putIfAbsent -> 없으면 put 해라 (k, v)
        for (String[] t : tickets) {
            map.putIfAbsent(t[0], new ArrayList<>());
            map.putIfAbsent(t[1], new ArrayList<>());
        }
        for (String[] t : tickets) {
            map.get(t[0]).add(t[1]);
        }
        // 정렬
        for (List<String> v : map.values()) {
            v.sort(Collections.reverseOrder());
        }

        dfs("ICN");
        String[] arr = answer.toArray(new String[0]);

        return arr;
    }

    public static void dfs(String start) {
        List<String> cur = map.get(start);
        while (!cur.isEmpty()) {
//            String next = cur.removeLast();
            String next = cur.remove(cur.size()-1);
            dfs(next);
            cur = map.get(start);   // 아니면 나와서 cur을 다시 원래대로 만들어줘
        }
        answer.addFirst(start);
    }

}