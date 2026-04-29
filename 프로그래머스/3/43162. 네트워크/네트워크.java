import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] connected = new boolean[n];
        int network = 0;

        for(int i = 0; i < n; i++){
            if(!connected[i]){
                connected[i] = true;
                bfs(i, n, computers, connected);
                network++;
            }
        }

        int answer = network;
        return answer;
    }

    public static void bfs(int computer, int n, int[][] computers, boolean[] connected){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(computer);

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 0; i < n; i++){
                if(computers[now][i] != 0 && !connected[i]){
                    connected[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}