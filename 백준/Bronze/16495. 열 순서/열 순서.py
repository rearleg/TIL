s = input()
answer = 0
for c in s:
    answer = answer * 26 + (ord(c) - ord('A') + 1)
print(answer)