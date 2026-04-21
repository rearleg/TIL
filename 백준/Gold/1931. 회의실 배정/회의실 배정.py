import sys

input = sys.stdin.readline

N = int(input())

meet = [list(map(int, input().split())) for _ in range(N)]

meet.sort(key=lambda x: (x[1], x[0]))
cnt = 0
end_time = 0

for i in meet:
    if i[0] >= end_time:
        cnt += 1
        end_time = i[1]

print(cnt)
