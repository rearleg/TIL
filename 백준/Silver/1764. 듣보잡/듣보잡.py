import sys
input = sys.stdin.readline

b, d = map(int, input().strip().split())
blist = set(input().strip() for _ in range(b))
dlist = set(input().strip() for _ in range(d))
dblist = sorted(blist & dlist)

print(len(dblist))
print('\n'.join(dblist))