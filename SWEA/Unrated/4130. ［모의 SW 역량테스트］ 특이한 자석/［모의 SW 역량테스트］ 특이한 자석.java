
import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> magnet1;
	static List<Integer> magnet2;
	static List<Integer> magnet3;
	static List<Integer> magnet4;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			magnet1 = new ArrayList<>();
			magnet2 = new ArrayList<>();
			magnet3 = new ArrayList<>();
			magnet4 = new ArrayList<>();
			int sum = 0;
			
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) magnet1.add(Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) magnet2.add(Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) magnet3.add(Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) magnet4.add(Integer.parseInt(st.nextToken()));
			
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				linkCheck(a, x, new boolean[5]);
			}
			
			sum += magnet1.get(0) == 1 ? 1 : 0;
			sum += magnet2.get(0) == 1 ? 2 : 0;
			sum += magnet3.get(0) == 1 ? 4 : 0;
			sum += magnet4.get(0) == 1 ? 8 : 0;
			
			System.out.println("#" + tc + " " + sum);
		}
 	}
	
	static void linkCheck(int a, int x, boolean[] rotated) {
		
		rotated[a] = true;
		if (a == 1) {
//			System.out.println(rotated[2]);
//			System.out.println(magnet1.get(2) + ", " + magnet2.get(6));
			if (!rotated[2] && magnet1.get(2) != magnet2.get(6) ) {
				linkCheck(2, (x*-1), rotated);
			}
		}
		
		if (a == 2) {
			if (!rotated[1] && magnet2.get(6) != magnet1.get(2)) {
				linkCheck(1, (x*-1), rotated);
			}
			if (!rotated[3] && magnet2.get(2) != magnet3.get(6)) {
				linkCheck(3, (x*-1), rotated);
			}
		}
		if (a == 3) {
			if (!rotated[2] && magnet3.get(6) != magnet2.get(2)) {
				linkCheck(2, (x*-1), rotated);
			}
			if (!rotated[4] && magnet3.get(2) != magnet4.get(6)) {
				linkCheck(4, (x*-1), rotated);
			}
		}
		if (a == 4) {
			if (!rotated[3] && magnet4.get(6) != magnet3.get(2) ) {
				linkCheck(3, (x*-1), rotated);
			}
		}
		magnetRotate(a, x);
		
	}
	
	
	static void magnetRotate(int n, int x) {
		if (n == 1) {
			if (x == -1) {
				magnet1.add(magnet1.remove(0));
			} else {
				magnet1.add(0, magnet1.remove(magnet1.size()-1));
			}
		}
		else if (n == 2){
			if (x == -1) {
				magnet2.add(magnet2.remove(0));
			} else {
				magnet2.add(0, magnet2.remove(magnet2.size()-1));
			}
		}
		else if (n == 3){
			if (x == -1) {
				magnet3.add(magnet3.remove(0));
			} else {
				magnet3.add(0, magnet3.remove(magnet3.size()-1));
			}
		}
		else if (n == 4) {
			if (x == -1) {
				magnet4.add(magnet4.remove(0));
			} else {
				magnet4.add(0, magnet4.remove(magnet4.size()-1));
			}
		}
	}
}


