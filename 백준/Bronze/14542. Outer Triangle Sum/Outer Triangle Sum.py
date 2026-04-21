import sys

input = sys.stdin.readline
CASE = 1
while True:
    n = int(input())
    if n == 0:
        break

    cnt = 0
    for _ in range(n):
        a = list(map(int, input().split()))
        if len(a) == 1 or len(a) == n:
            cnt += sum(a)
        else:
            cnt += a[0] + a[-1]

    print(f"Case #{CASE}:{cnt}")
    CASE += 1
