import java.util.*;

class Solution {
    static List<Integer> lst;

    public String[] solution(String[] expressions) {
        lst = new ArrayList<>();
        int[] possible = init(expressions);

        List<String> result = new ArrayList<>();

        for (int x : lst) {
            String[] e = expressions[x].split(" ");

            Set<String> answers = new HashSet<>();

            for (int base : possible) {
                if (!valid(e[0], base) || !valid(e[2], base)) continue;
                
                int a = Integer.parseInt(e[0], base);
                int b = Integer.parseInt(e[2], base);

                int value;
                if (e[1].equals("+")) value = a + b;
                else value = a - b;

                String answer = Integer.toString(value, base);
                answers.add(answer);
            }

            if (answers.size() == 1) {
                result.add(e[0] + " " + e[1] + " " + e[2] + " = " + answers.iterator().next());
            } else {
                result.add(e[0] + " " + e[1] + " " + e[2] + " = ?");
            }
        }

        return result.toArray(new String[0]);
    }

    static boolean valid(String n, int base) {
        for (char ch : n.toCharArray()) {
            if (ch - '0' >= base) return false;
        }
        return true;
    }

    static int[] init(String[] expressions) {
        boolean[] possible = new boolean[10];

        for (int base = 2; base <= 9; base++) {
            possible[base] = true;
        }

        int cnt = 8;

        for (int i = 0; i < expressions.length; i++) {
            String[] s = expressions[i].split(" ");

            if (s[4].equals("X")) {
                lst.add(i);

                for (int base = 2; base <= 9; base++) {
                    if (!possible[base]) continue;

                    if (!valid(s[0], base) || !valid(s[2], base)) {
                        possible[base] = false;
                        cnt--;
                    }
                }

                continue;
            }

            for (int base = 2; base <= 9; base++) {
                if (!possible[base]) continue;

                if (!valid(s[0], base) || !valid(s[2], base) || !valid(s[4], base)) {
                    possible[base] = false;
                    cnt--;
                    continue;
                }

                int a = Integer.parseInt(s[0], base);
                int b = Integer.parseInt(s[2], base);
                int c = Integer.parseInt(s[4], base);

                boolean good;
                if (s[1].equals("+")) {
                    good = a + b == c;
                } else {
                    good = a - b == c;
                }

                if (!good) {
                    possible[base] = false;
                    cnt--;
                }
            }
        }

        int[] result = new int[cnt];
        int idx = 0;

        for (int base = 2; base <= 9; base++) {
            if (possible[base]) {
                result[idx++] = base;
            }
        }

        return result;
    }
}