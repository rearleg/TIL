n = int(input())
lst = list(input() for _ in range(n))
max_l = 0
result =[]

lst = list(set(lst))

for i in lst:
    if len(i) > max_l:
        max_l = len(i)

for x in range(1, max_l+1):
    check = []
    for y in lst:
        if len(y) == x:
            check.append(y)
        else:
            pass
    check.sort()
    result += check

for line in result:
    print(line)