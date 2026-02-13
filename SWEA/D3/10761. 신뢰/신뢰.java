import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int locB = 1;
			int locO = 1;
			int timeB = 0;
			int timeO = 0;
			int curTime = 0;
			
			for (int i = 0; i < n; i++) {
				char robot = st.nextToken().charAt(0);
				int tg = Integer.parseInt(st.nextToken());
				
				// B로봇 도착 계산
				if (robot == 'B') {
					
					int arrivalTime = Math.abs(locB - tg) + timeB;
					int pressTime = Math.max(curTime, arrivalTime) + 1;
					locB = tg;
					curTime = pressTime;
					timeB = pressTime;
						
				}
				
				// O 로봇 도착 계산
				if (robot == 'O') {
					
					int arrivalTime = Math.abs(locO - tg) + timeO;
					int pressTime = Math.max(curTime, arrivalTime) + 1;
					locO = tg;
					curTime = pressTime;
					timeO = pressTime;
					
				}
				
			}
			System.out.println("#" + tc + " "+ curTime);
			
			
			
			
			
		}
		
		
		
	}
}
