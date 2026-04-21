t = int(input())

for _ in range(t):
    k = int(input())
    n = int(input())
    A = []
    for i in range(1, n + 1):
        A.append(i)
    for _ in range(k):
        for i in range(1, n):
            A[i] = A[i-1] + A[i]
    print(A[-1])


