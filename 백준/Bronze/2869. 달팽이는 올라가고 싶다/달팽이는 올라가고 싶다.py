a, b, v = map(int, input().split())

print((v - b + (a - b) - 1) // (a - b))