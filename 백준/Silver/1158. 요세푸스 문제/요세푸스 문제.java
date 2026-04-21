import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static Deque<Integer> yosephus(int N, int K) {
		Deque<Integer> queue = new ArrayDeque<>();
		Deque<Integer> arr = new ArrayDeque<>();
		
		// 배열 만들기
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		while (!arr.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				arr.add(arr.removeFirst());
			}
			queue.add(arr.pop());
		}
				
		return queue;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String result = yosephus(N, K).stream().map(String::valueOf).collect(Collectors.joining(", ", "<", ">"));
		System.out.println(result);
	}
}
