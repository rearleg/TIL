import java.nio.Buffer;
import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[] in;
    static int[] post;
    static int[] pos;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        in = new int[n+1];
        post = new int[n+1];
        pos = new int[n+1];

        // inorder 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) in[i] = Integer.parseInt(st.nextToken());

        // postorder 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) post[i] = Integer.parseInt(st.nextToken());

        // Inorder에서 각 값의 위치를 기록해둔다 (루트 위치를 찾기 위햄)
        // pos[value] = inorder에서 value가 있는 인덱스
        for (int i = 1; i <= n; i++) pos[in[i]] = i;

        // 전체 트리를 한번에 처리
        solve(1, n, 1, n);

        System.out.println(sb.toString());
    }

    static void solve(int inL, int inR, int postL, int postR) {
        if (inL > inR || postL > postR) return;

        // 후위 순회는 가장 마지막이 루트
        int root = post[postR];
        // 전위순회는 root부터
        sb.append(root).append(' ');

        // 중위순회에서 루트의 위치 찾기
        int k = pos[root];

        // 중위순회는 왼 -루트 - 오 이므로
        // 왼쪽 서브트리 노드 개수 = (루트 인덱스 - inorder 시작 인덱스)
        int leftSize = k - inL;

        // 왼쪽 서브트리
        solve(inL, k - 1, postL, postL + leftSize - 1);

        // 오른쪽 서브트리
        solve(k + 1, inR, postL + leftSize, postR - 1);

    }
}