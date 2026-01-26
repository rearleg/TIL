import java.util.*;
import java.io.*;

class Solution {
    public static int solution(int[][] routes) {
		
		int n = routes.length;
		// 진입구간 오름차, 같을 시 진출 기준
		Arrays.sort(routes, (a, b) -> {
			if (a[0] != b[0]) return a[0]-b[0];
			return a[1] - b[1];
		});
		
		// 최소 1개는 설치해야지
		int cnt = 1;
		int in = routes[0][0];
		int out = routes[0][1];
		
		
		for (int i = 1; i < n; i++) {
			int curIn = routes[i][0];
			int curOut = routes[i][1];
			if (out < curIn) {
				cnt++;
				in = curIn;
				out = curOut;
			} else {
//				in = Math.max(in,  curIn);
				out = Math.min(out, curOut);
			}
		}
		
	    int answer = 0;
	    return cnt;
	}
}
