n, m =map(int, input().split())

x = 10 ** m
print(((n + x // 2) // x) * x)