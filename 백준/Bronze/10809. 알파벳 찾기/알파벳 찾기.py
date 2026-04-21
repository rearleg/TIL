import sys
input = sys.stdin.readline

s = input().strip()
lst = [chr(i) for i in range(97, 123)]

for i in lst:
    print(s.find(i), end=' ')