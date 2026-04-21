import sys

input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
    p = list(input().rstrip())
    temp = 0
    if p[0] == ")" or p[-1] == "(":
        print("NO")
    else:
        for i in p:
            if i == "(" and temp >= 0:
                temp += 1
            elif i == ")" and temp >= 0:
                temp -= 1
            else:
                temp = -9999
        if temp == 0:
            print("YES")
        else:
            print("NO")
