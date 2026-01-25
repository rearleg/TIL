import java.util.*;


class Solution {
    public static int[] solution(int brown, int yellow) {

        // 1.
        // yellow가 되는 경우의 수를 만들어보고,
        // 경우에 따라 r + 2, c + 2를 했을 때 2(r+2) + 2(c+2) - 4의 값이 brown과 맞는지 체크 = 정답이라면 반환
        int halfY = yellow / 2;
        int r = yellow;
        int c = 1;
        int[] answer = {3, 3};
        
        // 절반만 찾아도됨
        for (int i = halfY + 1; i >= 1 ; i--) {
//            System.out.println("r = "+r+" c = "+c);
            if (2 * (r+2) + 2 * (c+2) - 4 == brown ) {
                answer = new int[] {r+2, c+2};

                return answer;
            }

            if (yellow % i == 0) {
                c = yellow / i;
                r = i;

            }
        }


        // 2.
        // brown이 되는 경우는 담아두고,
        // yellow가 되는 경우 양쪽의 +2가 .equals가 되는지 확인하면 맞다면
        // 그 값을 반환
        // 별로인 것 같음


        return answer;
    }
}