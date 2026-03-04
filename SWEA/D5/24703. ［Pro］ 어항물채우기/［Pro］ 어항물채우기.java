import java.util.*;

class UserSolution {

    class Tank {
        int id;
        int usedWater;
        int maxHeight;
        int[] shapes;       // 마지막 결합판의 종료를 나타낸 배열
        int[] heights;      // 각 열의 높이를 담고 있는 배열
        int[] filled;       // 해당 행에 채워진 칸 (n = 5일 때, 5면 채워진 것임
        int[] need;         // 각 층을 채우는데 필요한 물 (width - filled[r]
        int[] prefixNeed;   // need의 누적합
        int okCnt;

        Tank(int id, int h, int w) {
            this.id = id;
            usedWater = 0;
            shapes = new int[w];
            heights = new int[w];
            filled = new int[h];
            need = new int[h];
            prefixNeed = new int[h];
            okCnt = 0;
        }

        void getMaxHeight() {
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] > max) max = heights[i];
            }
            maxHeight = max;
        }

        void setPrefixNeed(int width, int height) {
            int acc = 0;
            for (int r = 0; r < height; r++) {
                need[r] = width - filled[r];
                acc += need[r];
                prefixNeed[r] = acc;
            }
        }

    }

    static Tank[] tanks;
    static int N;
    static int width;
    static int height;

    public void init(int nN, int mWidth, int mHeight, int[] mIDs, int[][] mLengths, int[][] mUpShapes) {
        // N = 어항의 갯수
        // mWidth = 어항의 가로 길이
        // mHeight = 어항의 세로 길이
        // mIDs[] = 어항의 ID, N만큼
        // mLengths[][] = 각 어항 별, 열 별 설치된 구조물의 높이
        // mUpShapes[][] = 각 어항 별, 열 별 설치된 구조물의 위쪽 결합판의 종류  (0 <= mUpShapes[][] <= 3)
        N = nN;
        width = mWidth;
        height = mHeight;
        tanks = new Tank[N];

        for (int i = 0; i < N; i++) {
            int curId = mIDs[i];
            Tank cur = new Tank(curId, mHeight, mWidth);

            // 행 별 높이 및 결합판 갱신
            for (int j = 0; j < mWidth; j++) {
                int len = mLengths[i][j];
                cur.heights[j] = len;
                cur.shapes[j] = mUpShapes[i][j];
                for (int k = 0; k < len; k++) cur.filled[k]++;

            }
            cur.getMaxHeight();                 // 최대 높이 갱신
            cur.setPrefixNeed(width, height);   // 누적합 갱신

            tanks[i] = cur;
        }

        Arrays.sort(tanks, (a, b) -> Integer.compare(a.id, b.id));

        // debug
//        System.out.println();
//        System.out.println("==== Init ====");
//        for (int i = 0; i < N; i++)
//            System.out.println("{ID:"+tanks[i].id+", maxHeight:"+
//                    tanks[i].maxHeight+", filled:"+
//                    Arrays.toString(tanks[i].filled) +"}");


    }
    // 우선순위
    // 1. 어항의 ID가 작을수록 우선순위가 높다.    -> 정렬
    // 2. 같은 어항내에서는 왼쪽으로 갈수록 우선순위가 높다.  -> 왼쪽부터 탐색


    // 주어진 구조물들을 설치할 수 있는 위치들의 수를 반환
    public int checkStructures(int[] mLengths, int[] mUpShapes, int[] mDownShapes) {

        // 1. 나란히 놓을 수 있는지 체크
        // 2. mUpShapes, mDownShapes를 Tank 내의 shapes와 일치한지 보고
        // 3. upShapes vs shapes, downShapes vs shapes
        // 4. 안되면 continue

        int cnt = 0;

        // tanks를 순회
        for (int idx = 0; idx < N; idx++) {
            Tank cur = tanks[idx];
            cur.okCnt = setOkCnt(cur, mLengths, mDownShapes);
            cnt += cur.okCnt;
        }
        // debug
//        System.out.println("(checkStructures) = " + cnt);
        return cnt;
    }

    // 주어진 구조물을 설치하고, 설치한 어항의 ID와 설치한 열 위치를 반환
    public int addStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
        // 반환 값은 "어항 ID * 1000 + 열 위치"

        // tanks 순회
        int ans = 0;
        outer1:
        for (int idx = 0; idx < N; idx++) {
            Tank cur = tanks[idx];

            outer2:
            for (int i = 0; i < width - 2; i++) {

                int prevHeight = cur.heights[i];

                int f0 = cur.heights[i], t0 = cur.heights[i] + mLengths[0];
                int f1 = cur.heights[i+1], t1 = cur.heights[i+1] + mLengths[1];
                int f2 = cur.heights[i+2], t2 = cur.heights[i+2] + mLengths[2];

                if (t0 <= f1 || t1 <= f0) continue outer2;
                if (t1 <= f2 || t2 <= f1) continue outer2;

                for (int j = i; j < i+3; j++) {
                    int curHeight = cur.heights[j];
                    int curShape = cur.shapes[j];
                    int tgHeight = mLengths[j-i];
                    int downShape = mDownShapes[j-i];

                    // 연결자가 맞지 않는 경우 continue
                    if (curShape != downShape) continue outer2;

                    // 높이가 천장을 뚫을 때
                    if (curHeight + tgHeight > height) continue outer2;


                    prevHeight = curHeight;

                }

                for (int k = cur.heights[i]; k < t0; k++) cur.filled[k]++;
                for (int k = cur.heights[i+1]; k < t1; k++) cur.filled[k]++;
                for (int k = cur.heights[i+2]; k < t2; k++) cur.filled[k]++;

                int id = cur.id;
                cur.heights[i] = t0;
                cur.heights[i+1] = t1;
                cur.heights[i+2] = t2;
                cur.shapes[i] = mUpShapes[0];
                cur.shapes[i+1] = mUpShapes[1];
                cur.shapes[i+2] = mUpShapes[2];

                int newMax = Math.max(t0, Math.max(t1, t2));
                if (newMax > cur.maxHeight) cur.maxHeight = newMax;
                cur.setPrefixNeed(width, height);

//                System.out.println("cur = {ID:"+cur.id+", filled:" + Arrays.toString(cur.filled)+"}");

                ans = id * 1000 + i+1;
                break outer1;
            }

        }

//        System.out.println("==== now ====");
//        for (int i = 0; i < N; i++) System.out.println("{ID:"+tanks[i].id+", maxHeight:"+tanks[i].maxHeight()+"}");

//        System.out.println("(addStructures) = " + ans);
        return ans;
    }

    // 주어진 물의 양은 mWater이며, 주어진 물을 이용해서 가장 높게 채울 수 있는
    // 어항 중 우선순위가 가장 높은 어항의 정보를 반환한다.
    public Solution.Result pourIn(int mWater) {
        Solution.Result ret = new Solution.Result();
        ret.ID = ret.height = ret.used = 0;

        int maxId = 0;
        int maxHeight = 0;
        int maxUsed = 0;

        // tanks 순회
        outer:
        for (int idx = 0; idx < N; idx++) {
            Tank cur = tanks[idx];

            int r = binarySearch(cur.prefixNeed, height, mWater);

            int curH;
            int used;
            if (r == -1) {
                curH = 0;
                used = 0;
            }
            else {
                curH = r + 1;
                used = cur.prefixNeed[r];
            }

            if (used == 0) continue;

            if (curH > maxHeight || (curH == maxHeight && used > maxUsed)) {
                maxId = cur.id;
                maxHeight = curH;
                maxUsed = used;
            }
        }

        ret.ID = maxId;
        ret.height = maxHeight;
        ret.used = maxUsed;

//        System.out.println("(pourIn) = {ID:" + maxId + ", height:"+maxHeight+", used:"+maxUsed+"}");

        return ret;
    }

    static int binarySearch(int[] prefixNeed, int H, int mWater) {
        int W = mWater;
        int lo = 0;
        int hi = H - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (prefixNeed[mid] <= W) {
                ans = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    static boolean canPlace(Tank cur, int i, int[] mLengths, int[] mDownShapes) {
        int f0 = cur.heights[i], t0 = cur.heights[i] + mLengths[0];
        int f1 = cur.heights[i+1], t1 = cur.heights[i+1] + mLengths[1];
        int f2 = cur.heights[i+2], t2 = cur.heights[i+2] + mLengths[2];

        if (t0 <= f1 || t1 <= f0) return false;
        if (t1 <= f2 || t2 <= f1) return false;

        // 연결자 + 천장 검사 (3칸)
        for (int j = 0; j < 3; j++) {
            int col = i + j;
            if (cur.shapes[col] != mDownShapes[j]) return false;
            if (cur.heights[col] + mLengths[j] > height) return false;
        }
        return true;
    }

    static int setOkCnt(Tank cur, int[] mLengths, int[] mDownShapes) {
        int cnt = 0;
        for (int i = 0; i < width - 2; i++) {
            if (canPlace(cur, i, mLengths, mDownShapes)) cnt++;
        }
        return cnt;
    }
}