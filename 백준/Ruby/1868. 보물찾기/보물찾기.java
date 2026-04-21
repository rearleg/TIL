import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        int mask = dfs(1, 0);

        // 가장 높은 비트 위치 = 최악 질문 횟수
        int answer = 31 - Integer.numberOfLeadingZeros(mask);
        System.out.println(answer);
    }

    static int dfs(int cur, int parent) {
        int curMask = 0;
        int maxHeight = 0;

        for (int next : tree[cur]) {
            if (next == parent) continue;

            int childMask = dfs(next, cur);

            // 같은 깊이 정보가 겹치면 한 단계 더 올려야 함
            if ((curMask & childMask) != 0) {
                int overlap = curMask & childMask;
                int h = 31 - Integer.numberOfLeadingZeros(overlap);
                maxHeight = Math.max(maxHeight, h);
            }

            curMask |= childMask;
        }

        // 현재 노드를 질문하는 경우를 반영
        curMask += (1 << maxHeight);

        // maxHeight 아래 비트는 정리
        if (maxHeight > 0) {
            curMask >>= maxHeight;
            curMask <<= maxHeight;
        }

        return curMask;
    }
}