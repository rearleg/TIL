import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
	static int max;
	static PriorityQueue<int[]> jewelryLoc;
	static int direction;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			jewelryLoc = new PriorityQueue<>((a,b) -> a[0]-b[0]);
			direction = 0;
			int n = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[n][n];
			
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] != 0) jewelryLoc.add(new int[] {arr[i][j], i, j});
				}
			}
			
		
//			System.out.println(jewelryLoc.stream().map(Arrays::toString).collect(Collectors.joining(" ")));
			
			int result = theGreatestJewelryThief(0, 0);
			
			System.out.println("#" + tc+" "+result);
		}
	}
	
	public static int theGreatestJewelryThief(int r, int c) {
		
		int cr = r;
		int cc = c;
		int cnt = 0;
		
		while (!jewelryLoc.isEmpty()) {
			int[] cur = jewelryLoc.poll();
			int tr = cur[1];
			int tc = cur[2];
			

			// 1. 내 위쪽 오른쪽에 있을 때
			if (tr < cr && tc > cc) {
				// 좌
				if (direction == 0) {
					cnt += 3;
					direction = 3;
					cr = tr;
					cc = tc;
				}
				// 하
				else if (direction == 1) {
					cnt += 3;
					direction = 0;
					cr = tr;
					cc = tc;
				}
				// 우
				else if (direction == 2) {
					cnt += 2;
					direction = 0;
					cr = tr;
					cc = tc;
				}
				// 위
				else {
					cnt += 1;
					direction = 0;
					cr = tr;
					cc = tc;
				}
			}

			// 2. 내 오른쪽 아래 있다면?
			else if (tr > cr && tc > cc) {
				// 좌
				if (direction == 0) {
					cnt += 1;
					direction = 1;
					cr = tr;
					cc = tc;
				}
				// 하
				else if (direction == 1) {
					cnt += 3;
					direction = 0;
					cr = tr;
					cc = tc;
				}
				// 우
				else if (direction == 2) {
					cnt += 3;
					direction = 1;
					cr = tr;
					cc = tc;
				}
				// 위
				else {
					cnt += 2;
					direction = 1;
					cr = tr;
					cc = tc;
				}
			}

			// 3. 내 아래 왼쪽에 있다면?
			else if (tr >cr && tc < cc) {
				// 좌
				if (direction == 0) {
					cnt += 2;
					direction = 2;
					cr = tr;
					cc = tc;
				}
				// 하
				else if (direction == 1) {
					cnt += 1;
					direction = 2;
					cr = tr;
					cc = tc;
				}
				// 우
				else if (direction == 2) {
					cnt += 3;
					direction = 1;
					cr = tr;
					cc = tc;
				}
				// 위
				else {
					cnt += 3;
					direction = 2;
					cr = tr;
					cc = tc;
				}
			}

			// 4. 내 왼쪽 위에 있다면?
			else if (tr < cr && tc < cc) {
				// 좌
				if (direction == 0) {
					cnt += 3;
					direction = 3;
					cr = tr;
					cc = tc;
				}
				// 하
				else if (direction == 1) {
					cnt += 2;
					direction = 3;
					cr = tr;
					cc = tc;
				}
				// 우
				else if (direction == 2) {
					cnt += 1;
					direction = 3;
					cr = tr;
					cc = tc;
				}
				// 위
				else {
					cnt += 3;
					direction = 2;
					cr = tr;
					cc = tc;
				}
			}
			
			
		}
		
		return cnt;
	}
	
	
}



