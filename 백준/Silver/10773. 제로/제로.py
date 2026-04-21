import sys

input = sys.stdin.readline

T = int(input().rstrip())
nums = []

for _ in range(T):
    x = int(input())
    if x == 0:
        nums.pop(-1)
    else:
        nums.append(x)
print(sum(nums))