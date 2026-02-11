
import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			// 금액
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] prices = new int[4];
			for (int i = 0; i < 4; i++) prices[i] = Integer.parseInt(st.nextToken());
			
			// 계획
			st = new StringTokenizer(br.readLine());
			int[] plan = new int[13];
			for (int i = 1; i < 13; i++) plan[i] = Integer.parseInt(st.nextToken());
//			System.out.println("plan = " + Arrays.toString(plan));
			
			
			int[] dp = new int[13];
			for (int i = 1; i < 13; i++) {

				// 일일권 고려
				dp[i] = dp[i-1] + Math.min(plan[i] * prices[0], prices[1]);
//				System.out.println("i = " + i + "일 때, plan[" + i + "] = " + plan[i] + " dp[" + i + "] = " + dp[i]);
				
				// 3개월 권 고려
				if (i >= 3) {
//					System.out.println("--3개월 고려 사항--");
//					System.out.println("i = " + i);
					dp[i] = Math.min(dp[i], dp[i-3] + prices[2]);
//					System.out.println("dp[" + i + "] = " + dp[i]);
					
				}
				
				// 1년권 고려
				if (i == 12) {
//					System.out.println("--12개월 고려 사항--");
//					System.out.println("i = " + i);
					dp[i] = Math.min(dp[i], prices[3]);
//					System.out.println("dp[" + i + "] = " + dp[i]);
				}
			}
			System.out.println("#" + tc + " " + dp[12]);
			
			
		}
	}
}
