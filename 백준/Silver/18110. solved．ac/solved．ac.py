import sys

n = int(input())
if n == 0:
    print(0)
else:
    l = sorted([int(x.rstrip()) for x in sys.stdin.readlines()])
    a = int((n * 0.15) + 0.5)
    if a != 0:
        print(int((sum(l[a:(-a)]) / len(l[a:(-a)])) + 0.5))
    else:
        print(int(sum(l) / len(l)))
