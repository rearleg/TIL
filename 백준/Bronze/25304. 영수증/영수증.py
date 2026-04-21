total = int(input())
n = int(input())
tp = 0

for _ in range(n):
    p, c = map(int, input().split())
    tp += p * c

if total - tp == 0:
    print('Yes')
else:
    print('No')