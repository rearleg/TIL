l = [[0] * 100 for _ in range(100)]
n = int(input())
cnt = 10000

for _ in range(n):
    a, b = map(int, input().split())
    for i in range(a, a+10):
        for j in range(b, b+10):
            l[i][j] += 1

for x in range(100):
    cnt -= l[x].count(0)
    
print(cnt)