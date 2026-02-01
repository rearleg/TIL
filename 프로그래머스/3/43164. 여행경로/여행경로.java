
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
        // 값 넣기
        for (String[] t : tickets) {
            map.get(t[0]).add(t[1]);
        }
        // 정렬 (방문 가능한 노드가 여러개라면, 오름차순으로 방문)
        for (List<String> v : map.values()) {
            // List에서 마지막 요소 빼는 건 O(1)이지만, 첫 요소 빼는 건 O(N)이다.
            // 그래서 반대로 정렬함
            v.sort(Collections.reverseOrder());
        }

        dfs("ICN");
        //정답 배열 만들기
        String[] arr = answer.toArray(new String[0]);

        return arr;
    }

    public static void dfs(String start) {
        // 1. start의 배열을 받고
        List<String> cur = map.get(start);
        // 2. 배열이 빌때까지 소모한다.
        while (!cur.isEmpty()) {
            // 마지막 요소 제거 후 next로 재귀 호출
//            String next = cur.removeLast(); // 프로그래머스에서 안됨
            String next = cur.remove(cur.size()-1);
            dfs(next);
//            cur = map.get(start);   // 아니면 나와서 cur을 다시 원래대로 만들어줘
        }
        answer.addFirst(start);
    }

}