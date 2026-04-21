while True:
    n = list(input())
    nn = n[::-1]
    if len(n) == 1 and n[0] == '0':
        break
    if n == nn:
        print("yes")
    else:
        print("no")