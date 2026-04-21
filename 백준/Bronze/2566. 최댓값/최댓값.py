import sys
l = []
mx = 0
for _ in range(9):
    l.append(list(map(int, sys.stdin.readline().split())))

for i in range(len(l)):
    if max(l[i]) > mx:
        mx = max(l[i])

for j in range(len(l)):
    if mx in l[j]:
        print(mx)
        print(j+1, l[j].index(mx)+1)
