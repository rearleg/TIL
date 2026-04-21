l = list(map(int, input().split()))
check = [1, 1, 2, 2, 2, 8]
a = []
for i in range(6):
    t = check[i] - l [i]
    a.append(t)

print(' '.join(map(str, a)))