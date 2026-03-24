import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 2_000_005;
    static int[] arr = new int[MAX];
    static int[] next = new int[MAX];
    static int[] prev = new int[MAX];
    static int[] pos = new int[MAX];

    static int idx;

    static StringBuilder sb = new StringBuilder();

    static void insert(int x, int y, boolean isP) {

        int node = idx++;         // 새 idx
        int cur = pos[x];   // 현재idx
        int pr = prev[cur];     // 이전idx
        int nx = next[cur];     // 다음idx

        arr[node] = y;          // arr의 새 idx에 y값 삽입
        pos[y] = node;          // 값 : idx 추가

        // 이전 역
        if (isP) {
            sb.append(arr[pr]).append("\n");
            // 새로 들어온 노드를 연결
            prev[node] = pr;
            next[node] = cur;
            prev[cur] = node;
            next[pr] = node;
        }
        else {
            sb.append(arr[nx]).append("\n");
            // 새로 들어온 노드를 연결
            next[node] = nx;
            prev[node] = cur;
            next[cur] = node;
            prev[nx] = node;
        }
    }

    static void delete(int x, boolean isP) {
        int cur = pos[x];   // 현재 idx

        if (isP) {
            int tg = prev[cur];
            int before = prev[tg];

            next[before] = cur;
            prev[cur] = before;

            sb.append(arr[tg]).append("\n");

        }

        else {
            int tg = next[cur];
            int after = next[tg];

            prev[after] = cur;
            next[cur] = after;

            sb.append(arr[tg]).append("\n");

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        idx = N;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            next[i] = i + 1 >= N ? 0 : i+1;
            prev[i] = i - 1 < 0 ? N-1 : i-1;
            pos[val] = i;
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(next));
//        System.out.println(Arrays.toString(prev));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("BN")) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                insert(x, y, false);
            }
            else if (cmd.equals("BP")) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                insert(x, y, true);
            }
            else {
                int x = Integer.parseInt(st.nextToken());
                delete(x, cmd.equals("CP"));
            }
        }
        System.out.println(sb.toString());

    }

}
