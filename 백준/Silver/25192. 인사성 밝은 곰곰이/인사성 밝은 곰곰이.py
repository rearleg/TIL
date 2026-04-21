n = int(input())
gomgom = set()
temp = 0
flag = False

for _ in range(n):
    come = input()
    if come == "ENTER":
        flag = True
        temp += len(gomgom)
        gomgom = set()
    else:
        if come not in gomgom and flag:
            gomgom.add(come)

print(len(gomgom) + temp)
