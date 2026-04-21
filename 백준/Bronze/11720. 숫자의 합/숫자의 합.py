n = int(input())
s = input()
lst = []
a = 0

for i in range(n):
    lst.append(int(s[i]))

for j in lst:
    a += j

print(a)