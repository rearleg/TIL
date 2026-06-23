// k = 나눌 그룹 수
// num = 각 시험장 응시자 수
// links = 시험장 연결

import java.util.*;

class Solution {
    
    static int cut;
    static int limit;
    
    public int solution(int k, int[] num, int[][] links) {
        int n = num.length;
        
        int root = findRoot(n, links);
        
        int left = 0;
        int right = 0;
        
        for (int x : num) {
            left = Math.max(left, x);
            right += x;
        }
        
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canDivide(root, mid, k, num, links)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        
        return answer;
    }
    
    static boolean canDivide(int root, int mid, int k, int[] num, int[][] links) {
        cut = 0;
        limit = mid;
        
        dfs(root, num, links);
        
        return cut + 1 <= k;
    }
    
    static int dfs(int cur, int[] num, int[][] links) {
        
        if (cur == -1) return 0;
        
        int leftChild = links[cur][0];
        int rightChild = links[cur][1];
        
        int leftSum = dfs(leftChild, num, links);
        int rightSum = dfs(rightChild, num, links);
        
        // 안 끊어도 되는지?
        if (num[cur] + leftSum + rightSum <= limit) {
            return num[cur] + leftSum + rightSum;
        }
        
        // 하나만 끊으면 되는가? (끊으면 작은 거)
        
        int smaller = Math.min(leftSum, rightSum);
        
        if (num[cur] + smaller <= limit) {
            cut++;
            return num[cur] + smaller;
        }
        
        // 둘 다 끊어야함?
        
        cut += 2;
        return num[cur];
    }
    
    static int findRoot(int n, int[][] links) {
        boolean[] isChild = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            int left = links[i][0];
            int right = links[i][1];
            
            if (left != -1) isChild[left] = true;
            if (right != -1) isChild[right] = true;
        }
        
        for (int i = 0; i < n; i++ ){
            if (!isChild[i]) return i;
        }
        return -1;
    }
}