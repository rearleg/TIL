n = int(input())
lst = list(input())
temp = 0

for i in range(n):
    m = ((ord(lst[i]) - 96) * (31 ** i))
    temp += m

print(temp % 1234567891)
