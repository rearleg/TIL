import sys

input = sys.stdin.readline

N, M = map(int, input().split())


def is_prime(n):
    if n == 3 or n == 2:
        return True

    if n == 1 or n % 2 == 0 or n % 3 == 0:
        return False

    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6

    return True


for n in range(N, M + 1):
    if is_prime(n):
        print(n)
