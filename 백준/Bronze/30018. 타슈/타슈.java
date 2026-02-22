import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int sum = 0;
        for (int i = 0; i < 2 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (i == 0) {arr1[j] = Integer.parseInt(st.nextToken());}
                else {arr2[j] = Integer.parseInt(st.nextToken());}
            }
        }

        for (int i = 0; i < n ; i++) {
            if (arr1[i] < arr2[i]) sum += arr2[i] - arr1[i];
        }
        System.out.println(sum);

    }

}