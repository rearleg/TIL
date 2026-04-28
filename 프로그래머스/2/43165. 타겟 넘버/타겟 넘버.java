public class Solution {
    static int[] op; //연산자(+, -) 저장 배열
    static int cnt; //방법의 수

    public int solution(int[] numbers, int target) {
        op = new int[numbers.length];
        cnt = 0;

        dfs(0, target, numbers);

        int answer = cnt;
        return answer;
    }

    public static void dfs(int depth, int target, int[] numbers){
        if(depth == op.length){
            int sum = 0;
            for(int i = 0; i < op.length; i++){
                int idx = op[i];
                int num = numbers[i];
                if(idx == 0){ //0 -> +
                    sum += num;
                } else if(idx == 1){ //1 -> -
                    sum -= num;
                }
            }
            if(sum == target) cnt++;
            return;
        }

        for(int i = 0; i < 2; i++){
            op[depth] = i;
            dfs(depth+1, target, numbers);
        }
    }
}
