
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[251];
		
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		
		
		
		for (int i = 2; i <= 250; i++) {
			dp[i] = dp[i-1].add(dp.clone()[i-2].multiply(BigInteger.valueOf(2)));
		}
		
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println("#"+tc+" "+dp[n]);
			
			
		}
	}
}
