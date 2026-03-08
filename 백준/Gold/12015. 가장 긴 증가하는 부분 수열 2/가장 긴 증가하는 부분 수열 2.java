import java.util.*;
import java.io.*;

/*
    dp[i] = i로 끝나는 LIS의 길이
    LIS 1의 코드는 O(N^2)으로, N이 100만이 넘는 경우 시간 초과
    
    때문에 i로 끝나는 가장 작은 수를 담는 lis 배열을 만들어 관리하여 길이 i일 때, 최소 끝값만 관리한다.
    최종적으로 lis의 길이를 출력하면 됨
    
    lis를 업데이트 하기 위해서 다음 조건이 있음
    1. lis의 끝값보다 큰 값이 들어온다면 append 해주기
    2. lis보다 작거나 같은 값 x가 들어온다면?
        2-1. x의 lowerBound(x이상인 값이 처음 등장하는 인덱스) 찾기   -> O(logN)
        2-2. lowerBound를 통해 나온 pos -> lis[pos]를 x로 대체하기
    3. 최종 len 업데이트하기
    
    모두 끝나면 len을 반환한다.
 */

class Main{
    static int n;
    static int[] arr;
    static int[] lis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n
        n = Integer.parseInt(br.readLine());

        // 배열
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        lis = new int[n];
        int len = 0;

        for (int x : arr) {
            int pos = lowerBound(len, x);
            lis[pos] = x;
            if (pos == len) len++;  // 가장 뒤에 붙은 경우 길이 증가
        }
        System.out.println(len);
    }

    static int lowerBound(int size, int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
