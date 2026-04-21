n = int(input())
lst = list(map(int, input().split()))
cnt = 0

for i in lst:
    if i < 2:
        continue
    for j in range(2, int(i**0.5) + 1):
        if i % j == 0:
            break
    else:
        cnt += 1
print(cnt)