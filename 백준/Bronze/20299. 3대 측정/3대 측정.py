import sys

input = sys.stdin.readline

N, K, L = map(int, input().split())

team = 0
member = []

for _ in range(N):
    x1, x2, x3 = map(int, input().split())
    total = x1 + x2 + x3
    if total >= K:
        if x1 >= L and x2 >= L and x3 >= L:
            team += 1
            member.append(x1)
            member.append(x2)
            member.append(x3)

print(team)
print(" ".join(map(str, member)))
