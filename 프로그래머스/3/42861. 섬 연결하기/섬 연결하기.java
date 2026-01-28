import java.util.*;


class Solution {
    static int[] parent;
	
	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
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
		
		// parent 배열 생성
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		// 크루스칼을 위한 정렬
		// 비용 오름차순
		Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
		
		for (int[] each : costs) {
			int s = each[0];
			int e = each[1];
			int cost = each[2];
			
			if (find(s) != find(e)) {
				union(s, e);
				totalCost += cost;
			}
		}
		return totalCost;
		
    }
}