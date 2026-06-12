// 이분탐색
// 총 걸리는 시간을 기준으로, mid = max(diff) / 2;
// 



class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
                
        int max = 0;
        int min = 1;
        for(int i = 0; i < diffs.length; i++) {
            max = Math.max(diffs[i], max);
        }
        
        int result = binary(min, max, limit, diffs, times);
        
        
        return result;
    }
    
    int binary(int min, int max, long limit, int[] diffs, int[] times) {
        int s = min;
        int e = max;
                
        while(s < e) {
            int mid = (s + e) / 2;
            
            //가능한가?
            if(can(mid, limit, diffs, times)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        
        return s;
        
    }
    
    boolean can(int level, long limit, int[] diffs, int[] times) {
        
        long total = 0;
        for (int i = 0; i < diffs.length; i++) {
            
            if(level >= diffs[i]) {
                total += times[i];
            } else {
                int diff = diffs[i] - level;
                int prevTime = i == 0 ? 0 : times[i-1];
                
                total += (times[i] + prevTime) * diff + times[i];
            }
            
        }
        System.out.println(total);
        
        return total <= limit;
    }
    
    
}

