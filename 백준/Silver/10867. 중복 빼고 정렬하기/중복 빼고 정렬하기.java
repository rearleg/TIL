import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		List<Integer> ans = new ArrayList<>();
		int temp = arr[0];
		sb.append(Integer.toString(arr[0]));
		for (int i = 1; i < n; i++) {
			if (temp != arr[i]) {
				ans.add(arr[i]);
				sb.append(" ").append(Integer.toString(arr[i]));
				temp = arr[i];
			}
		}
		System.out.println(sb);
	}

}
