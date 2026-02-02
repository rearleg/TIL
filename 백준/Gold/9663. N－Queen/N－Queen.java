import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] rowIdx;
	static int[] crossRLIdx;
	static int[] crossLRIdx;
	static int answer = 0;
	static int[][] chess;
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		chess = new int[n][n];
		rowIdx = new int[n];
		crossRLIdx = new int[n * 2 - 1];
		crossLRIdx = new int[n * 2 - 1];
		
		dfs(0, 0, n);
		System.out.println(answer);
		
	}
	
	public static void dfs(int r, int cnt, int n) {
		
		if (cnt == n) {
			answer++;
			return;
		}
		
		for (int c = 0; c < n; c++) {
			int crl = r - c + (n - 1);
			int clr = r + c;
			
			if (rowIdx[c] == 0 && crossRLIdx[crl] == 0 && crossLRIdx[clr] == 0) {
				rowIdx[c] = 1;
				crossRLIdx[crl] = 1;
				crossLRIdx[clr] = 1;
				
				dfs(r+1, cnt+1, n);
				rowIdx[c] = 0;
				crossRLIdx[crl] = 0;
				crossLRIdx[clr] = 0;
			}
			
			
			
			
		}
		
	}
}
