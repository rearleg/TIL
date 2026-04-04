
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

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N-1;

            boolean isDone = false;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    first = i;
                    second = left;
                    third = right;
                    isDone = true;
                    break;
                }

                if (Math.abs(sum) < max) {
                    max = Math.abs(sum);
                    first = i;
                    second = left;
                    third = right;
                }

                if (sum > 0) {
                    right--;
                }
                else if ( sum < 0) {
                    left++;
                }
            }

            if (isDone) break;
        }

        long[] ans = {arr[first], arr[second], arr[third]};
        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);

    }
}