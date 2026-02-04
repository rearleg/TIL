import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			
			StringBuilder sb = new StringBuilder();
			sb.append(s);
			String sReverse = sb.reverse().toString();
			
			if (s.equals(sReverse)) {
				System.out.println("#"+tc+" "+1);
			} else {
				System.out.println("#"+tc+" "+0);
			}
			
		}
	}
}
