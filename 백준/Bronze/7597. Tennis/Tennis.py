import sys

input = sys.stdin.readline

while True:
    s = input().rstrip()
    if s == "#":
        break

    score_a = 0
    score_b = 0
    win_a = 0
    win_b = 0
    for ch in s:
        if ch == "A":
            score_a += 1
        else:
            score_b += 1

        if score_a >= 4 and score_a - score_b >= 2:
            win_a += 1
            score_a = 0
            score_b = 0

        if score_b >= 4 and score_b - score_a >= 2:
            win_b += 1
            score_a = 0
            score_b = 0
    print(f"A {win_a} B {win_b}")
