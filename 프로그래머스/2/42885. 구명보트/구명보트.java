
import java.util.*;

class Solution {
    public static int solution(int[] people, int limit) {
		int n = people.length;
		Arrays.sort(people);
		
		int cnt = 0;
		
		
		int start = 0;
		int end = n - 1;
		
		while (start <= end) {
			if (people[start] + people[end] <= limit) {
				cnt++;
				start++;
				end--;
			} else {
				cnt++;
				end--;
			}
			
			if (start == end) {
				cnt++;
				end--;
			}
		}
		
		
		return cnt;
    }
	
}