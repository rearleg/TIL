
import java.util.*;
import java.io.*;

// 0 - 윗면
// 1 - 정면
// 2 - 오른쪽
// 3 - 뒷면
// 4 - 왼쪽
// 5 - 아랫면

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][][] cube;
    public static void main (String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            // 입력
            int n = Integer.parseInt(br.readLine().trim());
            String[] cmd = new String[n];

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n ; i++) cmd[i] = st.nextToken();

            // 큐브 초기화
            cubeInit();

            for (int i = 0; i < n; i++) {
                cubeRotate(cmd[i]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(cube[0][i][j]);
                }
                System.out.println();
            }

        }
    }

    static void cubeRotate(String cmd) {
        char face = cmd.charAt(0);
        char dir = cmd.charAt(1);

        // 윗면
        if (face == 'U') {
            rotateSurface(0, dir);

            char[] F = new char[3];
            char[] R = new char[3];
            char[] B = new char[3];
            char[] L = new char[3];

            for (int i = 0; i < 3; i++) {
                F[i] = cube[1][0][i];
                R[i] = cube[2][0][i];
                B[i] = cube[3][0][i];
                L[i] = cube[4][0][i];
            }

            if (dir == '-') {
                for (int i = 0; i < 3; i++) cube[1][0][i] = L[i];
                for (int i = 0; i < 3; i++) cube[2][0][i] = F[i];
                for (int i = 0; i < 3; i++) cube[3][0][i] = R[i];
                for (int i = 0; i < 3; i++) cube[4][0][i] = B[i];
            } else {
                for (int i = 0; i < 3; i++) cube[1][0][i] = R[i];
                for (int i = 0; i < 3; i++) cube[2][0][i] = B[i];
                for (int i = 0; i < 3; i++) cube[3][0][i] = L[i];
                for (int i = 0; i < 3; i++) cube[4][0][i] = F[i];
            }
        }
        // 아랫면
        else if (face == 'D') {
            rotateSurface(5, dir);

            char[] F = new char[3];
            char[] R = new char[3];
            char[] B = new char[3];
            char[] L = new char[3];

            for (int i = 0; i < 3; i++) {
                F[i] = cube[1][2][i];
                R[i] = cube[2][2][i];
                B[i] = cube[3][2][i];
                L[i] = cube[4][2][i];
            }

            if (dir == '-') {
                for (int i = 0; i < 3; i++) cube[1][2][i] = R[i];
                for (int i = 0; i < 3; i++) cube[2][2][i] = B[i];
                for (int i = 0; i < 3; i++) cube[3][2][i] = L[i];
                for (int i = 0; i < 3; i++) cube[4][2][i] = F[i];
            } else {
                for (int i = 0; i < 3; i++) cube[1][2][i] = L[i];
                for (int i = 0; i < 3; i++) cube[2][2][i] = F[i];
                for (int i = 0; i < 3; i++) cube[3][2][i] = R[i];
                for (int i = 0; i < 3; i++) cube[4][2][i] = B[i];
            }
        }
        // 정면
        else if (face == 'F') {
            rotateSurface(1, dir);

            char[] U = new char[3];
            char[] R = new char[3];
            char[] D = new char[3];
            char[] L = new char[3];

            for (int i = 0; i < 3; i++) {
                U[i] = cube[0][2][i];
                R[i] = cube[2][i][0];
                D[i] = cube[5][0][i];
                L[i] = cube[4][i][2];
            }

            if (dir == '+') {
                for (int i = 0; i < 3; i++) cube[0][2][i] = L[2 - i];
                for (int i = 0; i < 3; i++) cube[2][i][0] = U[i];
                for (int i = 0; i < 3; i++) cube[5][0][i] = R[2 - i];
                for (int i = 0; i < 3; i++) cube[4][i][2] = D[i];
            } else {
                for (int i = 0; i < 3; i++) cube[0][2][i] = R[i];
                for (int i = 0; i < 3; i++) cube[2][i][0] = D[2 - i];
                for (int i = 0; i < 3; i++) cube[5][0][i] = L[i];
                for (int i = 0; i < 3; i++) cube[4][i][2] = U[2 - i];
            }
        }
        // 뒷면
        else if (face == 'B') {
            rotateSurface(3, dir);

            char[] U = new char[3];
            char[] R = new char[3];
            char[] D = new char[3];
            char[] L = new char[3];

            for (int i = 0; i < 3; i++) {
                U[i] = cube[0][0][i];
                R[i] = cube[2][i][2];
                D[i] = cube[5][2][i];
                L[i] = cube[4][i][0];
            }

            if (dir == '+') {
                for (int i = 0; i < 3; i++) cube[0][0][i] = R[i];
                for (int i = 0; i < 3; i++) cube[2][i][2] = D[2 - i];
                for (int i = 0; i < 3; i++) cube[5][2][i] = L[i];
                for (int i = 0; i < 3; i++) cube[4][i][0] = U[2 - i];
            } else {
                for (int i = 0; i < 3; i++) cube[0][0][i] = L[2 - i];
                for (int i = 0; i < 3; i++) cube[2][i][2] = U[i];
                for (int i = 0; i < 3; i++) cube[5][2][i] = R[2 - i];
                for (int i = 0; i < 3; i++) cube[4][i][0] = D[i];
            }
        }

        // 왼쪽면
        else if (face == 'L') {
            rotateSurface(4, dir);

            char[] U = new char[3];
            char[] F = new char[3];
            char[] D = new char[3];
            char[] B = new char[3];

            for (int i = 0; i < 3; i++) {
                U[i] = cube[0][i][0];
                F[i] = cube[1][i][0];
                D[i] = cube[5][i][0];
                B[i] = cube[3][i][2];
            }

            if (dir == '+') {
                for (int i = 0; i < 3; i++) cube[0][i][0] = B[2 - i];
                for (int i = 0; i < 3; i++) cube[1][i][0] = U[i];
                for (int i = 0; i < 3; i++) cube[5][i][0] = F[i];
                for (int i = 0; i < 3; i++) cube[3][i][2] = D[2 - i];
            } else {
                for (int i = 0; i < 3; i++) cube[0][i][0] = F[i];
                for (int i = 0; i < 3; i++) cube[1][i][0] = D[i];
                for (int i = 0; i < 3; i++) cube[5][i][0] = B[2 - i];
                for (int i = 0; i < 3; i++) cube[3][i][2] = U[2 - i];
            }
        }
        // 오른면
        else if (face == 'R') {
            rotateSurface(2, dir);

            char[] U = new char[3];
            char[] F = new char[3];
            char[] D = new char[3];
            char[] B = new char[3];

            for (int i = 0; i < 3; i++) {
                U[i] = cube[0][i][2];
                F[i] = cube[1][i][2];
                D[i] = cube[5][i][2];
                B[i] = cube[3][i][0];
            }

            if (dir == '+') {
                for (int i = 0; i < 3; i++) cube[0][i][2] = F[i];
                for (int i = 0; i < 3; i++) cube[1][i][2] = D[i];
                for (int i = 0; i < 3; i++) cube[5][i][2] = B[2 - i];
                for (int i = 0; i < 3; i++) cube[3][i][0] = U[2 - i];
            } else {
                for (int i = 0; i < 3; i++) cube[0][i][2] = B[2 - i];
                for (int i = 0; i < 3; i++) cube[3][i][0] = D[2 - i];
                for (int i = 0; i < 3; i++) cube[5][i][2] = F[i];
                for (int i = 0; i < 3; i++) cube[1][i][2] = U[i];
            }
        }
    }

    // 면 회전
    static void rotateSurface(int n, char ch) {
        char[][] tmp = new char[3][3];

        if (ch == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tmp[j][2 - i] = cube[n][i][j];
                }
            }
        } else if (ch == '-') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tmp[2 - j][i] = cube[n][i][j];
                }
            }
        }
        cube[n] = tmp;
    }


    static void cubeInit() {
        // 큐브 초기화
        cube = new char[][][]
                {
                        // 윗면
                        {{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}},
                        // 앞면
                        {{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}},
                        // 오른쪽
                        {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}},
                        // 뒷면
                        {{'o', 'o', 'o'},{'o', 'o', 'o'},{'o', 'o', 'o'}},
                        // 왼쪽
                        {{'g', 'g', 'g'},{'g', 'g', 'g'},{'g', 'g', 'g'}},
                        // 아랫면
                        {{'y', 'y', 'y'},{'y', 'y', 'y'},{'y', 'y', 'y'}}
                };
    }
}