n = int(input())

if n < 100000:
    print(int(n * 0.05), int(n * 0.95))
elif n < 500000:
    print(int(n * 0.1), int(n * 0.9))
elif n < 1000000:
    print(int(n * 0.15), int(n * 0.85))
else:
    print(int(n * 0.2), int(n * 0.8))
