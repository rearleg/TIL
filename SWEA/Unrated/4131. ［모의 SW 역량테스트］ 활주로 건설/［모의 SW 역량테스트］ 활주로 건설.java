
import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int x;
	static int ans;;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			
			// 배열 만들기
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j< n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				int[] rowArr = new int[n];
				int[] columnArr = new int[n];
				for (int j = 0; j < n; j++) {
					rowArr[j] = arr[i][j];
					columnArr[j] = arr[j][i];
				}
				if (checkLine(rowArr)) {
//					System.out.println("i가 " + i +"일 때, rowArr 성공함");
					ans++;
				}
				
//				System.out.println("columnsArr 시작");
				if (checkLine(columnArr)) {
//					System.out.println("i가 " + i + "일 때, columnArr 성공함");
					ans++;
				}
				
			}
			
			System.out.println("#"+tc+" "+ans);

		}
		
	}
	
	static boolean checkLine(int[] arr) {
		
		int prev = arr[0];
		int sameCnt = 0;
		boolean[] visited = new boolean[n];
//		System.out.println("현재 : " + Arrays.toString(arr));
		
		for (int i = 0; i < n; i++) {
//			System.out.println("현재 i = " + i + " arr[i] = " + arr[i]);
			int diff = arr[i] - prev;
//			System.out.println("처음 diff = " + diff);
			
			// 같다면
			if (diff == 0) {
				sameCnt++;
//				System.out.println("넘어감");
				continue;
			}
			
			// 2이상 차이난다면
			if (diff > 1 || diff < -1) return false;
			
			// 올라간다면 앞에 x만큼 같아야한다.
			if (diff == 1) {
//				System.out.println("올라감");
				for (int k = i-1; k >= i - x; k--) {
//					System.out.println("k = " + k + ", i - x = " + (i - x));
					if (k < 0 || visited[k]) return false;
					visited[k] = true;
				}
				prev = arr[i];
			}
			
			// 내려간다면 뒤로 x만큼 같아야한다.
			if (diff == -1) {
//				System.out.println("내려감");
				for (int k = i+1; k < i + x; k++) {
//					System.out.println("i = " + i +"일 때, k가 " + k + "까지 감");
					if(k >= n || arr[i] != arr[k] || visited[k]) return false;
					visited[k] = true;
				}
				sameCnt = 1;
				
			}
			prev = arr[i];
			
		}
	
		return true;
	}

}


