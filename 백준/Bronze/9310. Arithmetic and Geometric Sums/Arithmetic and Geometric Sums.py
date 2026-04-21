import sys

input = sys.stdin.readline

while True:
    N = int(input())
    if N == 0:
        break

    arr = list(map(int, input().split()))
    # 등차수열이라면
    if arr[1] - arr[0] == arr[2] - arr[1]:
        temp = arr[1] - arr[0]
        answer = [arr[0]]
        for _ in range(N - 1):
            answer.append(answer[-1] + temp)
        print(sum(answer))
    else:
        temp = arr[1] // arr[0]
        answer = [arr[0]]
        for _ in range(N - 1):
            answer.append(answer[-1] * temp)
        print(sum(answer))
