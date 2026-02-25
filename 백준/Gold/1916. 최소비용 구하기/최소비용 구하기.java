import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dist;
	static List<List<int[]>> graph;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		graph = new ArrayList<>();
		
		int v = Integer.parseInt(br.readLine());
		// 초기화
		dist = new int[v+1];
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		int e = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new int[] {b, c});
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(dist[end]);
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		
		dist[start] = 0;
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int now = cur[0];
			int cost = cur[1];
			
			if (cost > dist[now]) continue;
			
			for (int[] edge : graph.get(now)) {
				
				int next = edge[0];
				int weight = edge[1];
				
				int newCost = dist[now] + weight;
				
				if (newCost < dist[next]) {
					dist[next] = newCost;
					pq.add(new int[] {next, newCost});
				}
				
			}
			
		}
		
	}
}
