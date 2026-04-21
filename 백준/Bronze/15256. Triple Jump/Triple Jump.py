import sys

input = sys.stdin.readline

T = int(input())
CASE = 1

for _ in range(T):
    n = int(input())
    lst = list(map(float, input().split()))
    foot = False
    cnt = []
    for i in lst:
        if i >= 30.0 and i <= 30.2 and not foot:
            foot = True
            continue
        if foot:
            cnt.append(i)

    print(f"Data Set {CASE}:")
    CASE += 1

    if foot and len(cnt) > 2:
        print(f"{min(cnt[2:]) - 30.0:.2f}")
    else:
        print("0.00")

    print()
