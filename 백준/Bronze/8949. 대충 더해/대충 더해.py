import sys

input = sys.stdin.readline

a, b = map(str, input().rstrip().split())

while len(a) != len(b):
    if len(a) < len(b):
        a = "0" + a
    else:
        b = "0" + b


lst = []

for i in range(len(a)):
    lst.append(int(a[i]) + int(b[i]))

print("".join(map(str, lst)))
