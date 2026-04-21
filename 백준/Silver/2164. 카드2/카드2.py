import sys

input = sys.stdin.readline

n = int(input())

if n == 1:
    print(1)
else:
    a = 1
    while a * 2 <= n:
        a *= 2
    answer = 2 * (n - a)
    if answer == 0:
        print(n)
    else:
        print(answer)
