n = int(input())

for _ in range(n):
    s = list(input())
    n = 0
    score = 0

    for i in s:
        if i == 'O':
            n += 1
            score += n
        else:
            n = 0

    print(score)