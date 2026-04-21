def prime(num):
    if num <= 1:
        return False

    if num == 2 or num == 3:
        return True

    if num % 2 == 0 or num % 3 == 0:
        return False

    i = 5
    while i * i <= num:
        if num % i == 0 or num % (i + 2) == 0:
            return False
        i += 6

    return True


m = int(input())
n = int(input())
lst = []

for i in range(m, n + 1):
    if prime(i):
        lst.append(i)

if lst:
    print(sum(lst))
    print(min(lst))
else:
    print(-1)
