n = int(input())

for _ in range(n):
    l = list(input().split())
    l[0] = 'god'
    print(''.join(map(str, l)))