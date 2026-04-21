n = int(input())
s = 1
temp = 666
while True:
    if n == s:
        break
    else:
        temp += 1
    if '666' in str(temp):
        s += 1

print(temp)