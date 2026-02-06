import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
//	static int cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		
		if (n >= 2) {
			dp[2] = 2;
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		System.out.println(dp[n]);
	}
}
