import sys

input = sys.stdin.readline

text = input().rstrip()
s = input().rstrip()
cnt = 0

while True:
    if s in text:
        text = text.replace(s, "✨", 1)
        cnt += 1
    else:
        break

print(cnt)
