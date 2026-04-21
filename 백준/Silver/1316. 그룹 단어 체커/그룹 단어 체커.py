t = int(input())
cnt = 0

for _ in range(t):
    s = input()
    n = 0
    check = []
    while len(s) > 0:
        if s[0] not in check:
            check.append(s[0])
            s = s.lstrip(s[0])
        else:
            break
    if s == '':
        cnt += 1
print(cnt)