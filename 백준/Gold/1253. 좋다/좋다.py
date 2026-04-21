import sys
input = sys.stdin.readline
n = int(input())
l = list(map(int, input().split()))
l.sort()
cnt = 0

for k in range(n):
    i, j = 0, n-1
    find = l[k]
    while i < j:
        if l[i] + l[j] == find:
            if i != k and j != k :
                cnt += 1
                break
            elif i == k:
                i += 1
            elif j == k:
                j -= 1
        elif l[i] + l[j] > find:
            j -= 1
        else:
            i += 1

print(cnt)

