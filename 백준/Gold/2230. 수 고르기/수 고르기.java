import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int s = 0;
        int e = 0;
        int answer = Integer.MAX_VALUE;

        while (e < n) {
            int sub = arr[e] - arr[s];

            if (sub >= m) {
                answer = Math.min(answer, sub);
                s++; 
            } else {
                e++; 
            }

            
            if (s > e) e = s;
        }

        System.out.println(answer);
    }
}
