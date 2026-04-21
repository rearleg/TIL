import sys

input = sys.stdin.readline

l = sorted(list(map(int, input().rstrip())), reverse=True)
print("".join(map(str, l)))
