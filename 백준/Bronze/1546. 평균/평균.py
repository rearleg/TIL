cnt = int(input())
lst = list(map(int, input().split()))
mx = max(lst)
sm = sum(lst)

print(sm*100 / mx / cnt)