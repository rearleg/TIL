
import java.util.*;
import java.io.*;

public class Main {

    static int low;
    static int high;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);


        int left = 0;
        int right = N - 1;

        long cur = Long.MAX_VALUE;

        while (left < right) {
            long sum = arr[left] + arr[right];
//            System.out.println(sum);

            if (sum == 0) {
                low = left;
                high = right;
                break;
            }

//            System.out.println(arr[left] + " + " + arr[right] + " = " + sum);

            if (Math.abs(sum) < cur) {
//                System.out.println("업데이트됨");
                cur = Math.abs(sum);
                low = left;
                high = right;
            }

            if (sum > 0) right--;
            else if (sum < 0) left++;
        }

        System.out.println(arr[low] + " " + arr[high]);
    }
}