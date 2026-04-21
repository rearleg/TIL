n = int(input())
cnt = []

for i in range(n//5 + 1):
    a = n - i * 5
    b = a // 3
    c = a % 3
    if c == 0:
        cnt.append(i + b)
if len(cnt) == 0:
    print(-1)
else:
    print(min(cnt))
