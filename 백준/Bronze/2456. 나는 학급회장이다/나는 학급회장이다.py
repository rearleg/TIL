import sys
input = sys.stdin.readline

N = int(input())

total = [0, 0, 0, 0]
cnt3  = [0, 0, 0, 0]
cnt2  = [0, 0, 0, 0]

for _ in range(N):
    a, b, c = map(int, input().split())
    scores = [0, a, b, c]
    for i in (1, 2, 3):
        s = scores[i]
        total[i] += s
        if s == 3:
            cnt3[i] += 1
        elif s == 2:
            cnt2[i] += 1

best = max((total[i], cnt3[i], cnt2[i]) for i in (1, 2, 3))

winners = [i for i in (1, 2, 3) if (total[i], cnt3[i], cnt2[i]) == best]

if len(winners) == 1:
    print(winners[0], best[0])
else:
    print(0, best[0])