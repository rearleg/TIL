import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] checked = new boolean[n]; //중복 방지, 네트워크 개수 계산
        int network = 0; //네트워크 수

        for(int i = 0; i < n; i++){
            if(!checked[i]){
                checked[i] = true;
                bfs(i, n, computers, checked);
                network++;
            }
        }

        int answer = network;
        return answer;
    }

    public static void bfs(int computer, int n, int[][] computers, boolean[] checked){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(computer);

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 0; i < n; i++){
                //computers의 값이 0이면 "연결 안 됨" 의미
                if(computers[now][i] != 0 && !checked[i]){
                    checked[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}