v = ['a', 'e', 'i', 'o', 'u']
vwy = ['a', 'e', 'i', 'o', 'u', 'y']
s = input()
cnt = 0
y_cnt = 0

for i in s:
    if i in v:
        cnt += 1
    if i in vwy:
        y_cnt += 1

print(cnt, y_cnt)