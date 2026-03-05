import java.util.*;

class UserSolution {

    class Road{
        int id;
        int depart;
        int arrival;
        int dist;

        Road(int id, int dep, int arr, int dist) {
            this.id = id;
            this.depart = dep;
            this.arrival = arr;
            this.dist = dist;
        }
    }
    static int N;
    static int K;
    static int[] costs;
    static Map<Integer, Road> roads;
    static Map<Integer, List<Road>> roadsStart;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    static int[] uniqCost;
    static Map<Integer, Integer> idx;


    public void init(int NnN, int mCost[], int Kk, int mId[], int sCity[], int eCity[], int mDistance[]) {
        N = NnN;
        K = Kk;
        roads = new HashMap<>();
        roadsStart = new HashMap<>();
        costs = mCost;

        for (int i = 0; i < K; i++) {
            Road road = new Road(mId[i], sCity[i], eCity[i], mDistance[i]);
            roads.put(mId[i], road);
            roadsStart.computeIfAbsent(sCity[i], k -> new ArrayList<>()).add(road);
        }

        //=========
        int[] tmp = Arrays.copyOf(costs, costs.length);
        Arrays.sort(tmp);

        int m = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (i == 0 || tmp[i] != tmp[i - 1]) m++;
        }
        uniqCost = new int[m];
        int p = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (i == 0 || tmp[i] != tmp[i - 1]) uniqCost[p++] = tmp[i];
        }

        idx = new HashMap<>(m * 2);
        for (int i = 0; i < m; i++) idx.put(uniqCost[i], i);
        //==========

//        System.out.println();
//        System.out.println("==== init ====");
//        System.out.println("roads : " + roads);
//        System.out.println("roadsStart : " + roadsStart);

        return;
    }

    public void add(int mId, int sCity, int eCity, int mDistance) {

        Road road = new Road(mId, sCity, eCity, mDistance);
        roads.put(mId, road);
        roadsStart.computeIfAbsent(sCity, k -> new ArrayList<>()).add(road);

//        System.out.println("(add) = {roads: " + roads.get(mId) + ", roadsStart: " + roadsStart.get(sCity) +"}");

        return;
    }

    public void remove(int mId) {


        List<Road> cur = roadsStart.get(roads.get(mId).depart);
        cur.removeIf(r -> r.id == mId);
        roads.remove(mId);

//        System.out.println("(remove) = " + cur);


        return;
    }

    public int cost(int sCity, int eCity) {
        int m = uniqCost.length;
        dist = new int[N][m];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);

        int[] cityIdx = new int[N];
        for (int c = 0; c < N; c++) cityIdx[c] = idx.get(costs[c]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int sIdx = cityIdx[sCity];
        dist[sCity][sIdx] = 0;
        pq.add(new int[] {0, sCity, sIdx});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int now = cur[1];
            int cIdx = cur[2];

            if (curCost != dist[now][cIdx]) continue;

            int w = uniqCost[cIdx];
            if (roadsStart.get(now) == null) continue;

            for (Road r : roadsStart.get(now)) {
                int next = r.arrival;
                int newCost = curCost + w * r.dist;

                int nextCityIdx = cityIdx[next];
                int nextIdx = Math.min(cIdx, nextCityIdx);

                if (newCost < dist[next][nextIdx]) {
                    dist[next][nextIdx] = newCost;
                    pq.add(new int[] {newCost, next, nextIdx});
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < m; i++) ans = Math.min(ans, dist[eCity][i]);
        return ans == INF ? -1 : ans;
    }
}