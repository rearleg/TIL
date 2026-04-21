a, m = map(int, input().split())
x = 1
while True:
    if (a * x) % m == 1:
        break
    else:
        x += 1

print(x)
