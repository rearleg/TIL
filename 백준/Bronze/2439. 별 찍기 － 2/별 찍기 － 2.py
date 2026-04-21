n = int(input())
cnt = 1

while n > 0:
    print(' '*(n-1)+'*'*cnt)
    cnt += 1
    n -= 1