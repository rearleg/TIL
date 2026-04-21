import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
//	static int cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
//			cnt = 0;
			int result = dfs(n,0);
			System.out.println(result);
		}
	}
	
	public static int dfs(int n, int ans) {
		
		if (ans == n) return 1;
		
		if (ans > n) return 0;
		
		int cnt = 0;
		
		for (int i = 1; i <= 3; i++) {
			cnt += dfs(n, ans + i);
		}
		
		return cnt;
		
	}
	
}

