import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    a, b = input().rstrip().split("-")
    temp = 0
    temp += (ord(a[0]) - 65) * (26**2)
    temp += (ord(a[1]) - 65) * (26**1)
    temp += ord(a[2]) - 65
    result = abs(temp - int(b))
    if result <= 100:
        print("nice")
    else:
        print("not nice")
