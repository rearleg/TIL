class Solution {
    int answer;
    void dfs (int index, int sum, int[] numbers, int target) {
        // 1. 탈출 조건
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        // 2. 수행동작

        dfs(index + 1, sum + numbers[index], numbers, target);
        dfs(index + 1, sum - numbers[index], numbers, target);
    }
    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(0,0, numbers, target);

        return answer;

    }
}