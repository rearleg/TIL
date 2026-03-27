import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int K;

    static long[] arr;  // 원본 배열
    static long[] tree; // 트리 배열
    static long[] lazy; // lazy 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[N * 4];
        lazy = new long[N * 4];

        // 초기 세그트리 구성
        init(1, 1, N);  // 시작 노드 1, 시작 idx 1, 끝 idx N

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());

                update(1, 1, N, b, c, d);
            }
            else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                sb.append(query(1, 1, N, b, c)).append('\n');
            }
        }
        System.out.println(sb);
    }

    // 세그트리 init
    // node가 [s, e] 구간을 담당한다고 할 때,
    // 그 구간의 합을 tree[node]에 저장
    static long init(int node, int start, int end) {

        // 리프 노드면 원본 배열 값 그대로 저장
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        // 왼쪽 자식 구간 + 오른쪽 자식 구간의 합
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid+1, end);
    }

    // push 함수
    // 현재 node에 밀려있는 lazy 값을 실제 tree[node]에 반영하고,
    // 자식에게 넘여야 하면 lazy를 자식에게 전달하는 함수
    // push -> 아래 배열로 업데이트 해줘야함
    static void push(int node, int start, int end) {

        // 미뤄둔 값이 없으면 할 일 없음
        if (lazy[node] == 0) return;

        // 현재 node가 담당하는 구간 길이 = (end - start + 1)
        // 이 구간의 모든 원소에 lazy[node] 만큼 더해야 하므로
        // 구간합에는 "구간 길이 * lazy값" 만큼 증가
        tree[node] += (end - start + 1) * lazy[node];

        // 리프가 아니라면
        // 아직 자식들에게 실제 반영은 안 했으니 lazy만 넘겨둔다
        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }

        // 현재 node의 lazy는 처리가 끝났으니 0으로 초기화
        lazy[node] = 0;
    }

    // 구간 업데이트
    // [left, right] 구간에 diff를 더한다.
    static void update(int node, int start, int end, int left, int right, long diff) {

        // 이 node에 예전에 미뤄둔 작업이 있으면 먼저 처리
        push(node, start, end);

        // 1. 아에 안 겹치는 경우
        if (right < start || end < left) {
            return;
        }

        // 2. 현재 구간이 업데이트 구간에 완전히 포함되는 경우
        if (left <= start && end <= right) {
            // 현재 구간 전체에 diff를 더한 효과를 tree[node]에 즉시 반영
            tree[node] += (end - start + 1) * diff;

            // 리프가 아니라면 자식에게 나중에 처리하라고 미뤄둠
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }

        // 3. 일부만 겹치는 경우
        // 왼쪽 / 오른쪽 자식으로 내려가서 처리
        int mid = (start + end) / 2;

        update(node * 2, start, mid, left, right, diff);
        update(node * 2 + 1, mid+1, end, left, right, diff);

        // 자식들의 값이 갱신되었으므로 현재 node의 합도 다시 계산
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int start, int end, int left, int right) {

        // 현재 node에 밀린 lazy가 있으면 먼저 반영
        push(node, start, end);

        // 1. 아에 안 겹치면 합에 영향 없음
        if (right < start || end < left) {
            return 0;
        }

        // 2. 현재 구간이 질의 구간에 완전히 포함되면
        // 이 node가 들고 있는 합을 그대로 반환
        if (left <= start && end <= right) {
            return tree[node];
        }

        // 3. 일부만 겹치면 왼쪽/오른쪽 자식으로 나눠서 합산
        int mid = (start + end) / 2;

        long leftSum = query(node * 2, start, mid, left, right);
        long rightSum = query(node * 2 + 1, mid+1, end, left, right);

        return leftSum + rightSum;
    }
}

