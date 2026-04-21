h, m = map(int, input().split())

if (m - 45) < 0:
    m = m + 60 - 45
    h -= 1
else:
    m -= 45

if h == -1:
    h = 23

print(h, m)