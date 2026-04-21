import sys

input = sys.stdin.readline

a, k = map(int, input().split())
cnt = 0
while k != a:
    if k - 1 >= a and k % 2 == 1:
        k -= 1
        cnt += 1
    elif k // 2 >= a and k % 2 == 0:
        k //= 2
        cnt += 1
    else:
        k -= 1
        cnt += 1


print(cnt)
