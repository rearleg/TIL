import java.util.*;
import java.io.*;

public class Main {

    static int[] tree;

    static final int MAX = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new int[4 * MAX];

        // build는 필요 없음

        // 실행
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            // b번 사탕 하나 꺼내기
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int ans = query(1, 1, MAX, b);
                update(1, 1, MAX, ans, -1);
                System.out.println(ans);
            }

            // b맛의 사탕 c개 추가하기
            else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(1, 1, MAX, b, c);
            }
        }
    }

    static int query(int node, int start, int end, int rank) {
        // 리프라면 start return
        if (start == end) return start;

        // 아니라면 어디에 속하는지 보자.
        int mid = (start + end) / 2;

        // 오른쪽에 속한다면, 왼쪽만큼을 빼줘야함. ㅇㅋ?
        if (tree[node*2] >= rank) return query(node*2, start, mid, rank);
        else return query(node*2+1, mid+1, end, rank - tree[node*2]);
    }

    static void update(int node, int start, int end, int idx, int diff) {
        // idx가 범위 밖이라면 return
        if ( idx < start || end < idx) return;

        // 범위 내라면 현재 node에 diff를 추가해주세용
        tree[node] += diff;

        // 리프인지 확인
        if (start == end) return;

        // 리프가 아니라면?
        // 자식으로 내리기
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid+1, end, idx, diff);
    }
}
