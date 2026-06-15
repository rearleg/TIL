class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // t초동안 x/s만큼 회복
        // t초 성공 시 y 추가 체력, 다시 0으로 초기화
        // 최대 체력 이상 불가, 0이면 회복 불가능
        // 공격당하면 기술 취소, 다시 0초부터 카운트
        
        int prevAtk = 0;
        int n = 0;
        int curHealth = health;
        
        for (int[] atk : attacks) {
            // System.out.println(n);
            
            int spenTime = atk[0] - prevAtk - 1;
            
            // 1. 회복한다.
            int heal = (bandage[1] * spenTime) + (spenTime / bandage[0] * bandage[2]);
            curHealth = Math.min(curHealth + heal, health);
            
            // 2. 공격당한다.
            System.out.println("공격 당하기 전 체력 = " + curHealth + " 최종 힐량 = " + heal);
            curHealth -= atk[1];
            prevAtk = atk[0];
            
            // 3. 생존 체크
            if (curHealth < 1) {
                return -1;
            }
            System.out.println(curHealth);
        }
        
        int answer = curHealth;
        return answer;
    }
}