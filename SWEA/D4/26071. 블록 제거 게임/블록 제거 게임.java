import java.util.*;
import java.io.*;

public class Solution {
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			max = 0;
			int n = Integer.parseInt(br.readLine());
			List<Integer> arr = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) arr.add(Integer.parseInt(st.nextToken())); 
			
			dfs(arr, 0, 0, n);
			
			System.out.println("#" + tc+ " "+max);
			
		}
	}
	
	public static int dfs(List<Integer> arr, int sum, int depth, int n) {
		
		if (arr.size() == 0) {
			max = Math.max(max, sum);
			return sum;
		}
		
		for (int i = 0; i < arr.size(); i++) {
			
			int x = arr.get(i);
			
			// 어떤 걸 부수고 있냐?
			if (arr.size() == 1) {
				sum += x;
				arr.remove(i);
				dfs(arr, sum, depth+1, n);
				sum -= x;
				arr.add(i, x);
				
			}
			else if (i == 0) {
				int nxt = arr.get(i+1);
				sum+= nxt;
				arr.remove(i);
				dfs(arr, sum, depth+1, n);
				sum -= nxt;
				arr.add(i, x);
			}
			else if (i == arr.size() - 1 ) {
				int prev = arr.get(i-1);
				sum += prev;
				arr.remove(i);
				dfs(arr, sum, depth+1, n);
				sum -= prev;
				arr.add(i, x);
			}
			else {
				int prev = arr.get(i-1);
				int nxt = arr.get(i+1);
				sum += prev * nxt;
				arr.remove(i);
				dfs(arr, sum, depth+1, n);
				sum -= prev * nxt;
				arr.add(i, x);
			}
		}
		
		return sum;
	}
}