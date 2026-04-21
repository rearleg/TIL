while True:
    n, m = map(str, input().split())
    if n == "0" and m == "0":
        break
    a = [n]
    b = [m]
    a_len = 0
    b_len = 0
    answer = []

    switch = True
    while switch:
        temp = 0
        for i in a[-1]:
            temp += int(i) ** 2
        if str(temp) in a:
            switch = False
        else:
            a.append(str(temp))

    switch = True
    while switch:
        temp = 0
        for i in b[-1]:
            temp += int(i) ** 2
        if str(temp) in b:
            switch = False
        else:
            b.append(str(temp))

    for i in a:
        if i in b:
            a_len = a.index(i) + 1
            b_len = b.index(i) + 1
            answer.append(a_len + b_len)
    if len(answer) == 0:
        print(n, m, 0)
    else:
        print(n, m, min(answer))