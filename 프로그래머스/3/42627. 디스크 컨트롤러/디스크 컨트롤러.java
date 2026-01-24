import java.util.*;

class Solution {
    public static int solution(int[][] jobs) {
        // pq 정의
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        // jobs에 작업 번호(들어온 순서) 붙여서 3개로 만들기
        int l = jobs.length;
        int[][] newJobs = new int[l][3];
        for (int i = 0; i < l; i++) {
            newJobs[i][0] = jobs[i][0];
            newJobs[i][1] = jobs[i][1];
            newJobs[i][2] = i;
        }

        // 요청 시간대로 sort를 하고 요청 시간이 같다면, 들어온 순서대로 정렬
        Arrays.sort(newJobs, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        // 변수를 정의하자
        int sum = 0;    // 최종 반환ㄴ 시간 업데이트
        int time = 0;   // 현재 시간
        int p = 0;      // newJobs를 가리키는 포인터임 (pq를 하나 더 쓸까 싶었는데 이렇게 해보고싶었ㅇ음)
        int complete = 0;

        // complete가 jobs의 길이만큼 도달할 때까지 반복
        while (complete < l) {

            // 현재 시간까지 요청된 작업들 pq에 넣기
//            while (newJobs[p][0] <= time) {  // 포인터는 길이까지만 늘어나야함 안 그러면 ArrayIndexOutOfBoundsException 남
            while (p < l && newJobs[p][0] <= time) {
                pq.add(newJobs[p]);
                p++;
            }

            // 현재 시간까지 작업이 들어오지 않으면 가장 가까운 도착 시간까지 넘어감
            if (pq.isEmpty()) {
                time = newJobs[p][0];
                // 타임 워프 했으니 다시 첨부터 실행
                continue;
            }

            // 작업 하나씩 완료해주고 최종 반환 시간 업데이트
            int[] cur = pq.poll();
            int r = cur[0];
            int d = cur[1];
            time += d;
            sum += (time - r);
            complete++;
        }
        // complete가 도달하면, 평균 구해주기
        int answer = sum / l;

        return answer;
    }
}