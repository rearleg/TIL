import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int min;
	static int max;
	static int[] opers;
	static int[] nums;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			int n = Integer.parseInt(br.readLine());
			opers = new int[4];
			nums = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				opers[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				nums[i] = Integer.parseInt(st.nextToken());

			dfs(n, 1, nums[0]);

			System.out.println("#" + tc + " " + Math.abs(min - max));
		}
	}

	static void dfs(int n, int k, int value) {

		if (k == n) {
			min = Math.min(value, min);
			max = Math.max(value, max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int cur = nums[k];
			if (opers[i] > 0) {
				int cal = 0;
				if (i == 0)
					cal = value + cur;
				if (i == 1)
					cal = value - cur;
				if (i == 2)
					cal = value * cur;
				if (i == 3)
					cal = value / cur;
				opers[i]--;
				dfs(n, k + 1, cal);

				opers[i]++;
			}
		}
	}

}
