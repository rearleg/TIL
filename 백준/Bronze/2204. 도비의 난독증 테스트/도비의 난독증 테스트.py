import sys

input = sys.stdin.readline

while True:
    n = int(input())
    lst = []
    upper_lst = []
    if n == 0:
        break
    for _ in range(n):
        line = input().rstrip()
        lst.append(line)
        upper_lst.append(line.upper())
    print(lst[upper_lst.index(min(upper_lst))])
