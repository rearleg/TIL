import java.io.*;
import java.util.*;

class Solution {
        public static int solution(int[] citations) {

        Arrays.sort(citations);
        int l = citations.length;
        int answer = 0;
        int temp = 0;

        for (int i = 0; i < l; i++) {
            int c = citations[i];
            int more = l - i;
            if (c >= more ) {
                temp = Math.min(c, more);
                answer = Math.max(temp, answer);
            }
        }
//        int answer = 0;
        return answer;
    }
}