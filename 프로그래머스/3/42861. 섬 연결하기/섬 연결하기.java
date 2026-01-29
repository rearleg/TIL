import java.util.*;


class Solution {
    static int[] parent;
	
	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]); // 처음 find 시 최악의 경우 O(n)이지만 경로 압축 후 O(1)
	}
	
	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			if (rootX < rootY) {
				parent[rootY] = rootX;
			} else {
				parent[rootX] = rootY;
			}
		}
	}
	
	public static int solution(int n, int[][] costs) {
		int totalCost = 0;
		// 조기 종료를 위한 cnt 변수 
		int cnt = 0;
		
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
		
		for (int[] each : costs) {
			// cnt가 n - 1이 되면 조기 종료
			if (cnt == n - 1) break;
			int s = each[0];
			int e = each[1];
			int cost = each[2];
			if (find(s) != find(e)) {
				union(s, e);
				totalCost += cost;
				// 연결 시 cnt 올려주기
				cnt++;
			}
		}
		return totalCost;
		
    }
}