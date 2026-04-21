T = int(input())

for _ in range(T):
    C = int(input())
    lst = [0, 0, 0, 0]
    lst[0] = C // 25
    C %= 25
    lst[1] = C // 10
    C %= 10
    lst[2] = C // 5
    C %= 5
    lst[3] = C

    print(" ".join(map(str, lst)))