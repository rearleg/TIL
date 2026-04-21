import sys

input = sys.stdin.readline

a, b = map(int, input().split())
result = 1
while a <= b:
    temp = 0
    for i in range(1, a + 1):
        temp += i
    result *= temp
    a += 1

print(result % 14579)
