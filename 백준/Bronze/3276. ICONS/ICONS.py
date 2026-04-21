n = int(input())
a, b = 1, 1
while True:
    if a * b < n:
        a += 1
    if a * b < n:
        b += 1
    if a * b >= n:
        break

print(a, b)