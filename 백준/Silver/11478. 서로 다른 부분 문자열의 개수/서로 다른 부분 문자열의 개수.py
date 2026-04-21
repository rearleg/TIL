import sys

input = sys.stdin.readline

s = input().rstrip()
lst = []
for i in range(len(s)):
    x = len(s)
    while i < x:
        lst.append(s[i:x])
        x -= 1

print(len(set(lst)))
