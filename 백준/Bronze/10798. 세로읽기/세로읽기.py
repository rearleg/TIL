l = [input() for _ in range(5)]
new_l = []
ver = ''

for j in range(max(len(s) for s in l)):
    ver = ''
    for i in l:
        try:
            ver += i[j]
        except IndexError:
            pass
    new_l.append(ver)

print(''.join(map(str, new_l)))