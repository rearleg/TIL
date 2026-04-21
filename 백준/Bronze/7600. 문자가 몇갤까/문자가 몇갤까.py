check = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]

while True:
    s = input().upper()
    l = []
    if s == "#":
        break
    for i in s:
        if i in check and i not in l:
            l.append(i)
    print(len(l))

