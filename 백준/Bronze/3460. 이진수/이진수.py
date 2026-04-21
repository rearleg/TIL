import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    binary = ""
    result = []
    n = int(input())
    while n >= 1:
        binary = binary + str(n % 2)
        n = n // 2

    for i in range(len(binary)):
        if binary[i] == "1":
            result.append(i)

    print(" ".join(map(str, result)))
