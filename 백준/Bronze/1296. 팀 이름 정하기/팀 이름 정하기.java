import java.io.*;
import java.util.*;

public class Main {
    static boolean isLOVE(char ch) {
        return ch == 'L' || ch == 'O' || ch == 'V' || ch == 'E';
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이름 및 후보 갯수
        String name = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int bestScore = -1;
        String bestTeam = null;

        for (int i = 0; i < n; i++) {
            String team = br.readLine();

            int L = 0, O = 0, V = 0, E = 0;
            String line = name + team;

            for (int k = 0; k < line.length(); k++) {
                char ch = line.charAt(k);
                if (ch == 'L') L++;
                else if (ch == 'O') O++;
                else if (ch == 'V') V++;
                else if (ch == 'E') E++;
            }
            int score = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100;

            if (score > bestScore || (score == bestScore && team.compareTo(bestTeam) < 0)) {
                bestScore = score;
                bestTeam = team;
            }
        }
        System.out.println(bestTeam);
    }
}