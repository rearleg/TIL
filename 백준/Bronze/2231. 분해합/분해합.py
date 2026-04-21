n = int(input())
x = n - 54
result = 0

if x >= 0:
    while x <= (n - 3):
        lst = list(str(x))
        a = x
        for i in lst:
            a += int(i)
        if a == n:
            print(x)
            break
        x += 1

if x < 0:
    x = 1
    while x <= n:
        lst = list(str(x))
        a = x
        for i in lst:
            a += int(i)
        if a == n:
            print(x)
            break
        x += 1

if a != n:
    print(0)