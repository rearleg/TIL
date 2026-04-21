import sys

input = sys.stdin.readline
shorts = list(map(int, sys.stdin.readlines()))
total = sum(shorts)
for i in range(8):
    for j in range(i + 1, 9):
        if total - shorts[i] - shorts[j] == 100:
            shorts.pop(j)
            shorts.pop(i)
            break
    if len(shorts) == 7:
        break

shorts.sort()
print("\n".join(map(str, shorts)))
