import sys

input = sys.stdin.readline

line = input().split()
h = int(line[0])
cmd = line[1] if len(line) > 1 else ""

temp = 1
for ch in cmd:
    if ch == "L":
        temp = temp * 2
    else:
        temp = temp * 2 + 1

answer = (2 ** (h + 1)) - temp

print(answer)