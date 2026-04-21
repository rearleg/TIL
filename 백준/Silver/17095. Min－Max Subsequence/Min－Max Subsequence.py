import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

mx = max(arr)
mn = min(arr)

if mx == mn:
    print(1)

else:
    last_mn = -1
    last_mx = -1
    ans = 10**18

    for i, x in enumerate(arr):
        if x == mn:
            last_mn = i
            if last_mx != -1:
                ans = min(ans, i - last_mx + 1)
        if x == mx:
            last_mx = i
            if last_mn != -1:
                ans = min(ans, i - last_mn + 1)

    print(ans)
