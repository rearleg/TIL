
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);

        int first = 0;
        int second = 0;
        int third = 0;

        long max = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int cur = i;
            int left = i == 0 ? 1 : 0;
            int right = i == N-1 ? N-2 : N-1;

            boolean isDone = false;

            while (left < right) {
                long sum = arr[cur] + arr[left] + arr[right];
                if (sum == 0) {
                    first = cur;
                    second = left;
                    third = right;
                    isDone = true;
                    break;
                }

                if (Math.abs(sum) < max) {
                    max = Math.abs(sum);
                    first = cur;
                    second = left;
                    third = right;
                }

                if (sum > 0) {
                    right--;
                    if (right == cur) right--;
                }
                else if ( sum < 0) {
                    left++;
                    if (left == cur) left++;
                }
            }

            if (isDone) break;
        }

        long[] ans = {arr[first], arr[second], arr[third]};
        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);

    }
}