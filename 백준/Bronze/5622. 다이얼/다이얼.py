s = list(input())
lst = []
for i in s:
    if i == 'A' or i == 'B' or i == 'C':
        lst.append(3)
    elif i == 'D' or i ==  'E' or i ==  'F':
        lst.append(4)
    elif i == 'G' or i ==  'H' or i == 'I':
        lst.append(5)
    elif i == 'J' or i == 'K' or i == 'L':
        lst.append(6)
    elif i == 'M' or i == 'N' or i == 'O':
        lst.append(7)
    elif i == 'P' or i == 'Q' or i == 'R' or i == 'S':
        lst.append(8)
    elif i == 'T' or i == 'U' or i == 'V':
        lst.append(9)
    else:
        lst.append(10)

print(sum(lst))