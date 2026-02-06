
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[1001];
		
		dp[0] = 1;
		dp[1] = 1;
		
		
		
		for (int i = 2; i <= 1000; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
		}
		

		int n = Integer.parseInt(br.readLine());
		System.out.println(dp[n]);
			
			
	}
}
