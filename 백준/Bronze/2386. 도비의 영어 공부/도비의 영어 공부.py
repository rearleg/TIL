import sys

input = sys.stdin.readline


while True:
    s = input().rstrip()
    if s == "#":
        break

    target = s[0]
    s = s[2:].lower()
    cnt = 0
    for ch in s:
        if ch == target:
            cnt += 1
    print(target, cnt)
