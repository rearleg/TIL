import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] cards = new int[12];
			for (int i = 0; i < 12; i++) cards[i] = Integer.parseInt(st.nextToken());

			int[] f1 = new int[10];
			int[] f2 = new int[10];
			int c1 = 0, c2 = 0;

			int winner = 0;

			for (int turn = 0; turn < 12; turn++) {
				int x = cards[turn];

				if ((turn & 1) == 0) {
					f1[x]++; c1++;
					if (c1 >= 3 && winCheckPermutationHell(f1, c1)) { winner = 1; break; }
				} else {
					f2[x]++; c2++;
					if (c2 >= 3 && winCheckPermutationHell(f2, c2)) { winner = 2; break; }
				}
			}

			out.append("#").append(tc).append(" ").append(winner).append("\n");
		}

		System.out.print(out);
	}

	static boolean winCheckPermutationHell(int[] freq, int k) {
		int[] hand = new int[k];
		int idx = 0;
		for (int d = 0; d < 10; d++) {
			for (int c = 0; c < freq[d]; c++) hand[idx++] = d;
		}

		ArrayList<int[]> perms = new ArrayList<>();
		permuteAll(hand, 0, perms);

		for (int[] p : perms) {
			StringBuilder sb = new StringBuilder();
			for (int v : p) sb.append((char)('0' + v));
			String s = sb.toString();

			int[] arr = new int[k];
			for (int i = 0; i < k; i++) arr[i] = s.charAt(i) - '0';

			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					if (j == i) continue;
					for (int m = 0; m < k; m++) {
						if (m == i || m == j) continue;

						int a = arr[i], b = arr[j], c = arr[m];

						if (isWinningTripleByExhaustiveProof(a, b, c)) return true;
					}
				}
			}
		}

		return false;
	}

	// 4D exhaustive proof:
	// w loop is 0..7 (8 values) and each w repeats the same 3D scan twice.
	// This gives about 16x cost compared to the previous 3D proof.
	static boolean isWinningTripleByExhaustiveProof(int a, int b, int c) {
		int[] t = {a, b, c};
		sort3(t);

		for (int w = 0; w < 5; w++) { // multiplier 11
			for (int x = 0; x <= 9; x++) {
				for (int y = 0; y <= 9; y++) {
					for (int z = 0; z <= 9; z++) {

						boolean win = false;

						if (x == y && y == z) win = true;
						else {
							int[] u = {x, y, z};
							sort3(u);
							if (u[0] + 1 == u[1] && u[1] + 1 == u[2]) win = true;
						}

						if (!win) continue;

						int[] u = {x, y, z};
						sort3(u);

						if (u[0] == t[0] && u[1] == t[1] && u[2] == t[2]) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	static void sort3(int[] a) {
		if (a[0] > a[1]) { int t = a[0]; a[0] = a[1]; a[1] = t; }
		if (a[1] > a[2]) { int t = a[1]; a[1] = a[2]; a[2] = t; }
		if (a[0] > a[1]) { int t = a[0]; a[0] = a[1]; a[1] = t; }
	}

	static void permuteAll(int[] a, int idx, ArrayList<int[]> out) {
		if (idx == a.length) {
			out.add(a.clone());
			return;
		}
		for (int i = idx; i < a.length; i++) {
			swap(a, idx, i);
			permuteAll(a, idx + 1, out);
			swap(a, idx, i);
		}
	}

	static void swap(int[] a, int i, int j) {
		int t = a[i]; a[i] = a[j]; a[j] = t;
	}
}