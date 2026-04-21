import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 재원 받기
        st = new StringTokenizer(br.readLine());
        int jaewon = 0;
        for (int i=0; i < 3; i++) {
            jaewon += Integer.parseInt(st.nextToken());
        }

        // 친구들 받기
        for (int i=1; i <= N; i++) {
            // i번째 친구 총합 구하기
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j=0; j < 3; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            // 총합이 재원의 이하이면 list에 추가
            if (sum <= jaewon) {
                list.add(new int[]{sum, i});
            }
        }

        // list 정렬하기
        list.sort((a, b) -> Integer.compare(b[0], a[0]));

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        // 재원 추가
        sb.append(0);

        int limit = Math.min(M-1, list.size());
        for (int k = 0; k < limit; k++) {
            sb.append(" ").append(list.get(k)[1]);
        }
        System.out.println(sb.toString());
    }
}