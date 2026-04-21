import sys

input = sys.stdin.readline

n = int(input())
l = list(map(int, input().split()))
set_l = sorted(list(set(l)))
t = 0
dic = {}
answer = []
for i in set_l:
    dic[i] = t
    t += 1

for j in l:
    answer.append(dic[j])
print(" ".join(map(str, answer)))
