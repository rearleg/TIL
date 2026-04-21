import sys

input = sys.stdin.readline

n = int(input())
temp = 1
for i in range(1, n + 1):
    temp *= i
cnt = 0
lst = list(str(temp))
while True:
    if lst[-1] != "0":
        break
    cnt += 1
    lst.pop()
print(cnt)
