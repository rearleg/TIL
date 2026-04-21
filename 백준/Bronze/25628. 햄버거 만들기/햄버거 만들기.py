b, p = map(int, input().split())
cnt = 0
while b >= 0 and p >= 0:
    b -= 2
    p -= 1
    if b >= 0 and p >= 0:
        cnt += 1

print(cnt)
