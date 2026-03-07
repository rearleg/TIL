import java.util.*;
import java.io.*;

class Main{

    static int[] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m ; i++) mArr[i] = Integer.parseInt(st.nextToken());


        for (int k : mArr) {
            System.out.print(binarySearch(k) + " ");
        }

    }

    static int binarySearch(int k) {

        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (arr[mid] == k) return 1;

            if (arr[mid] > k) e = mid - 1;
            else s = mid + 1;
        }

        return 0;
    }


}
