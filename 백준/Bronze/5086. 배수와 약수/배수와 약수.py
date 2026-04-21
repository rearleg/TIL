while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    if m > n and m % n == 0:
        print("factor")
    elif n > m and n % m == 0:
        print("multiple")
    else:
        print("neither")
