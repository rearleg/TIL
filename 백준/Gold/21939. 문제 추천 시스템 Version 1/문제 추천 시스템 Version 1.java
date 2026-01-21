
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 문제 맵 전역
    static Map<Integer, Integer> problems = new HashMap<>();
//    static TreeSet<int[]> rankAsc = new TreeSet<>((a, b) -> a[1] - b[1]);
    static TreeSet<int[]> rankAsc = new TreeSet<>((a, b) -> {
        if (a[1] != b[1]) return a[1] - b[1];
        return a[0] - b[0];
});

//    static TreeSet<int[]> rankDesc = new TreeSet<>((a, b) -> b[1] - a[1]);


    public static void main(String[] args) throws Exception {

        // N 받기
        int N = Integer.parseInt(br.readLine());

        // 문제 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            problems.put(p, l);
            rankAsc.add(new int[] {p, l});
        }

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            // 명렁문 받기
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();     // 명령어
            int v1 = Integer.parseInt(st.nextToken());    // 값
            int v2 = 0;
            // add의 경우 3개로 들어오니 혹시 token이 3개라면 v2를 받음
            if (st.hasMoreTokens()) {
                v2 = Integer.parseInt(st.nextToken());
            }
            // 명령문 3가지 종류 분기 처리
//            if (cmd.equals("solved") ) {
//                rankAsc.removeIf(arr -> arr[0] == v1); // O(n)
//                rankDesc.removeIf(arr -> arr[0] == v1);
//                problems.remove(v1);
            if (cmd.equals("solved") ) {
                if(problems.containsKey(v1))
                    rankAsc.remove(new int[] {v1, problems.get(v1)});
//                rankDesc.remove(new int[] {v1, problems.get(v1)});
                problems.remove(v1);

            } else if (cmd.equals("add") && v2 != 0) {
                rankAsc.add(new int[] {v1, v2});
//                rankDesc.add(new int[] {v1, v2});
                problems.put(v1, v2);

            } else {
                if (v1 == 1) {
                    System.out.println(rankAsc.last()[0]);
                } else {
//                    System.out.println(rankDesc.last()[0]);
                    System.out.println(rankAsc.first()[0]);
                }
            }


        }


    }
}