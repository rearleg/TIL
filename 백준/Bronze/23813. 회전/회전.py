s = input()
result = 0
for i in s[::-1]:
    s = i + s[:-1]
    result += int(s)
print(result)