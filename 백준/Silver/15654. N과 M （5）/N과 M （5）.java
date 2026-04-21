import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.management.OperatingSystemMXBean;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		dfs(n, m, arr, new ArrayList<>());
		
	}
	
	static void dfs(int n, int m, int[] arr, List<Integer> tmp) {
		if (tmp.size() == m) {
			System.out.println(tmp.stream().map(String::valueOf).collect(Collectors.joining(" ")));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (tmp.contains(arr[i])) continue;
			tmp.add(arr[i]);
			dfs(n, m, arr, tmp);
			tmp.remove(tmp.size()-1);
		}
		
	}
}
