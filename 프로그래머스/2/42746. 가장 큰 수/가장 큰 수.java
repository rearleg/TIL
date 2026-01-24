import java.util.*;
class Solution {
    public static String solution(int[] numbers) {
        int n = numbers.length;
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));

        // 정렬 후 가장 앞에 0이 온다면, 모든 값이 0이기 때문에 "0"하나만 리턴해줘야힘;;
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }
        String answer = sb.toString();
        return answer;
    }
}