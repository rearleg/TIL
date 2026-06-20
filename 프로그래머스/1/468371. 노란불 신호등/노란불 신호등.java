class Solution {
    public int solution(int[][] signals) {
        int limit = 1;
        
        for (int[] s : signals) {
            int period = s[0] + s[1] + s[2];
            limit = lcm(limit, period);
        }
        
        for (int t = 1; t <= limit; t++) {
            boolean allYellow = true;
            
            for (int[] s : signals) {
                int g = s[0];
                int y = s[1];
                int r = s[2];
                
                int period = g + y + r;
                int pos = (t - 1) % period + 1;
                
                if (!(g < pos && pos <= g + y)) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return t;
            }
            
        }
        
        return -1;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}