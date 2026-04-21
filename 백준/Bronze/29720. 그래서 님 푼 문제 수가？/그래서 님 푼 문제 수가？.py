n, m, k = map(int, input().split())

a = n - (m * k)
b = n - (m * k) + (m * k - m * (k - 1) - 1)
print(a if a > 0 else 0, b if b > 0 else 0)
