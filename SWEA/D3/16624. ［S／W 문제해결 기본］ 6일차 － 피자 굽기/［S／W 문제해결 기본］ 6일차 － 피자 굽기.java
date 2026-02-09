
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
/*
 * 1 - 상, 2 - 우, 3 - 하, 4 - 좌
 */

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<int[]> q1 = new ArrayDeque<>();
            Queue<int[]> q2 = new ArrayDeque<>();

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++)
                q1.add(new int[] {i+1,Integer.parseInt(st.nextToken())});

            for (int i = 0; i < n; i++)
                q2.add(q1.poll());

            // q2가 비었다면,
            while (q2.size() > 1) {
                // q2의 사이즈가 n보다 작으면 (화덕 안에 자리가 있다면)
//                if (q2.size() < n) {
//                    while (q2.size() < n && !q1.isEmpty()) {
//                        q2.add(q1.poll());
//                    }
//                }

                // 한바퀴 돌리기
                for (int i = 0; i < q2.size(); i++) {
                    int[] tmp = q2.poll();
                    tmp[1] /= 2;
                    // 0이라면 끝!
                    if (tmp[1] == 0) {
                        if(!q1.isEmpty()) {
                            q2.add(q1.poll());
                        }
                        continue;
                    }

                    q2.add(tmp);
                }

//                System.out.println(q2.stream().map(Arrays::toString).collect(Collectors.joining(" ")));;

//                System.out.println(q2);
            }
            int[] ans = q2.poll();
            System.out.println("#"+tc + " "+ans[0]);



        }
    }

}

