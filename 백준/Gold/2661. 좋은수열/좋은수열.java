import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		
		// 입력
		int n = Integer.parseInt(br.readLine());
		
		String ans = dfs(n, "");
		
		System.out.println(ans);
		
	}
	
	public static String dfs(int n, String ans) {
		
		
		if (ans.length() == n) return ans;
		
		for (int i = 1; i <= 3; i++) {
			
			String next = ans + String.valueOf(i);
			
			if(isGood(next)) {
				String result = dfs(n, next);
				if (result != null) return result;
			}
						
		}
		return null;
		
		
	}
	
	public static boolean isGood(String s) {
		int l = s.length();
		
		for (int i = 1; i <= l / 2; i++) {
			String rear = s.substring(l - i);
			String front = s.substring(l - 2 * i, l - i);
			if (rear.equals(front)) return false;
		}
		
		return true;
	}
}
