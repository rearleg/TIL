import sys

input = sys.stdin.readline

tg = input().rstrip()
words = []

for line in sys.stdin.readlines():
    lst = list(map(str, line.rstrip().split()))
    for ch in lst:
        words.append(ch)

cnt = 0

for i in words:
    if i.upper().rstrip(".") == tg.upper().rstrip("."):
        cnt += 1

print(cnt)
