import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] sudoku;
	static List<int[]> zeros;
	// boolean [idx][number]
	static boolean[][] rows = new boolean[9][10];
	static boolean[][] columns= new boolean[9][10];
	static boolean[][] squares= new boolean[9][10];
	
	public static void main(String[] args) throws Exception {

		//  
		sudoku = new int[9][9];
		
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		for (int tg = 1; tg <= 9; tg++) {
//			int[] rows = new int[9];
//			int[] columns = new int[9];
//			int[] square = new int[9];
			// 3x3 격자를 봐야하는 걸 만들어야함
			// 9분면 돌 것들 
			/*
			 * 0 = 0, 1 = 0, 2 = 0, 3 = 1 ... -> i / 3
			 * 0 = 0, 1 = 1, 2 = 2, 3 = 0 ... -> i % 3
			 */
			// 배열 만들기
			for (int i = 0; i < 9; i++) {
				int startR = i / 3 * 3;
				int startC = i % 3 * 3;
				for (int j = 0; j < 9; j++) {
					int r = startR + j / 3; // 0, 0, 0, 1, 1, 1, 2, 2, 2
					int c = startC + j % 3; // 0, 1, 2, 0, 1, 2, 0, 1, 2
					if (sudoku[i][j] == tg) rows[i][tg] = true;
					if (sudoku[j][i] == tg) columns[i][tg] = true;
					if (sudoku[r][c] == tg) squares[i][tg] = true;
				}
			}
		}
		zeros = new ArrayList<>();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if(sudoku[r][c] == 0) zeros.add(new int[] {r, c});
			}
		}
		
		dfs(0);
	
		for(int i = 0; i < 9; i++) {
			String s = Arrays.stream(sudoku[i]).boxed().map(String::valueOf).collect(Collectors.joining(" "));
			System.out.println(s);
			// Stream<T>
			// IntStream\
			// intStream.boxed() => Stream<Integer>
			// {0, 1, 2, 3, 4} = IntStream.range(0, 5).toArray(); in[]
		}
	}
	
	public static boolean dfs(int idx) {
		
		if (idx == zeros.size()) return true;
		
		int r = zeros.get(idx)[0];
		int c = zeros.get(idx)[1];
		int sr = (r / 3) * 3 + (c / 3);
		
		for (int i = 1; i <= 9; i++) {
			if (!rows[r][i] && !columns[c][i] && !squares[sr][i]) {
				sudoku[r][c] = i;
				rows[r][i] = true;
				columns[c][i] = true;
				squares[sr][i] = true;
				
				if (dfs(idx+1)) return true;

				sudoku[r][c] = 0;
				rows[r][i] = false;
				columns[c][i] = false;
				squares[sr][i] = false;

			}
		}
		
		return false;
	}
}

