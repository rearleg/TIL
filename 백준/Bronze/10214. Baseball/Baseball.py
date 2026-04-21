N = int(input())

for _ in range(N):
    Y, K = 0, 0
    for _ in range(9):
        x, y = map(int, input().split())
        Y += x
        K += y

    if Y > K:
        print("Yonsei")
    elif Y < K:
        print("Korea")
    else:
        print("Draw")
