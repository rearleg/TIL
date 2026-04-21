import sys

input = sys.stdin.readline

n = int(input())
s = input().rstrip()
x, y = map(int, input().split())

HYU = {"H": 0, "Y": 0, "U": 0}
cnt = 0
energy = 0

for ch in s:
    if ch in "HYU":
        if cnt > 0:
            energy += min(cnt * x, y + x)
            cnt = 0

        HYU[ch] += 1
    else:
        cnt += 1

if cnt > 0:
    energy += min(cnt * x, y + x)

if energy == 0:
    print("Nalmeok")
else:
    print(energy)

answer = min(HYU.values())

if answer == 0:
    print("I love HanYang University")
else:
    print(answer)
