lst = list(enumerate(input()))
check = int(lst[-1][1])
lst.pop()
temp = 0
for i in range(len(lst)):
    if lst[i][1] == "*":
        if i % 2 == 0 or i == 0:
            double = 1
        else:
            double = 3
    else:
        if lst[i][0] == 0 or int(lst[i][0]) % 2 == 0:
            temp += int(lst[i][1])
        else:
            temp += int(lst[i][1]) * 3

for j in range(10):
    if (temp + j * double + check) % 10 == 0:
        print(j)
