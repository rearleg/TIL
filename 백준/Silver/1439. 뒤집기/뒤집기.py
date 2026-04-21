import sys

input = sys.stdin.readline

s = input().rstrip()
cnt_zero = 0
cnt_one = 0

if s[0] == "0":
    cnt_zero += 1
else:
    cnt_one += 1

for i in range(1, len(s)):
    if s[i - 1] != s[i]:
        if s[i] == "0":
            cnt_zero += 1
        else:
            cnt_one += 1

print(min(cnt_zero, cnt_one))
