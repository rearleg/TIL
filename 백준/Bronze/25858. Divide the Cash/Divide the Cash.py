import sys
n, m = map(int, input().split())
l = [int(line.rstrip()) for line in sys.stdin.readlines()]
x = m / sum(l)

for i in range(n):
    print(int(l[i]*x))