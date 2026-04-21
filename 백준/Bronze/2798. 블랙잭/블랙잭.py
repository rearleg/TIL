n, m = map(int, input().split())
lst = list(map(int, input().split()))
num = m
result = 0

for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            a = lst[i]+lst[j]+lst[k]
            if m - a == 0:
                num = m - a
                result = a
                break
            elif a < m and m - a < num:
                num = m - a
                result = a
            else:
                pass

print(result)