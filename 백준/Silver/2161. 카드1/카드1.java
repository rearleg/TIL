import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> arr = new ArrayDeque<>();
		List<Integer> ans = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		
		while (true) {
			if (!arr.isEmpty()) {
				ans.add(arr.removeFirst());
			} else {
				break;
			}
			if (!arr.isEmpty()) {
				arr.add(arr.removeFirst());
			}
		}
		String result = ans.stream().map(num -> String.valueOf(num)).collect(Collectors.joining(" "));
		System.out.println(result);
	}
}
