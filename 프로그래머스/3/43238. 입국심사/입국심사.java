class Solution {
    static public long solution(int n, int[] times) {
        // 최대값 먼저 구하기
        long max = getMax(times);

        return binary(n, max, times);
    }

    static long binary(int n, long max, int[] times) {
        long ans = 0;

        long l = 0;
        long r = max * n;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (can(n, mid, times)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }

    static boolean can(int n, long limit, int[] times) {

        long total = 0;

        for (int t : times) {
            total += limit / t;

            if (total >= n) return true;
        }

        return total >= n;
    }

    static long getMax(int[] times) {
        long max = 0;
        for (int x : times) {
            if (x > max) max = x;
        }
        return max;
    }



    public static void main(String[] args)throws Exception{
        System.out.println(solution(6, new int[] {7, 10}));
    }
}


