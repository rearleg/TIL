n, m = map(int, input().split())
if n + m >= 5:
    print('yt')
else:
    if n == 1:
        if m == 3:
            print('yj')
        else:
            print('yt')
    elif n == 2 or n == 3:
        print('yj')
