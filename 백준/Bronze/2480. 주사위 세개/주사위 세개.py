n, m, x = map(int, input().split())

if n == m == x:
    print(10000+n*1000)
elif m == n or m == x:
    print(1000+m*100)
elif n == x:
    print(1000+n*100)
else:
    if n > m and n > x:
        print(n*100)
    elif m > n and m > x:
        print(m*100)
    elif x > n and x > m:
        print(x*100)