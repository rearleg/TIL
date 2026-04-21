n, w, h = map(int, input().split())

for _ in range(n):
    l = int(input())
    if (w**2) + (h**2) >= l**2:
        print('DA')
    else:
        print('NE')