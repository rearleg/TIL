import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dist;
	static List<List<int[]>> graph;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		dist = new int[V + 1];
		
		for (int i =0; i <= V; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new int[] {v, w});
		}
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void dijkstra(int start) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		
		dist[start] = 0;
		pq.add(new int[] {start, 0});
		
		while (!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int now = cur[0];
			int cost = cur[1];
			
			if (cost > dist[now]) continue;
			
			for (int[] edge : graph.get(now)) {
				
				int next = edge[0];
				int weight = edge[1];
				
				int newCost = dist[now] + weight;
				
				// relax
				if (newCost < dist[next]) {
					dist[next] = newCost;
					pq.offer(new int[] {next, newCost});
				}
				
			}
			
		}
		
		
	}
}
