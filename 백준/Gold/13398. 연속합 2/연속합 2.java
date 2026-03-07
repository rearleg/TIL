import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = arr[0];
        int[] left = new int[n];
        left[0] = arr[0];
        for (int i = 1; i<n; i++) {
            left[i] = Math.max(arr[i], left[i-1] + arr[i]);
            max = Math.max(max, left[i]);   // 하나도 제거하지 않았을 때
        }

        int[] right = new int[n];
        right[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i+1] + arr[i]);
        }

        for (int i = 1 ; i < n - 1 ; i ++) {
            max = Math.max(max, left[i-1] + right[i+1]);    // i를 하나 제거했을 때
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        System.out.println(max);
    }
}
