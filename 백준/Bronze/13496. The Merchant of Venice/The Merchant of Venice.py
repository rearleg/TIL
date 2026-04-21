import sys

input = sys.stdin.readline

T = int(input())
data = 1
for _ in range(T):
    n, s, d = map(
        int, input().split()
    )  # n = 배의 갯수, s = 배의 이동 속도/일, d = 계약 기한까지 남은 일수
    gold = 0

    for _ in range(n):
        x, y = map(
            int, input().split()
        )  # d = i번째 배와 베니스 사이의 거리, v = i번째 배에 실린 화물의 가치
        if x / s <= d:
            gold += y

    print(f"Data Set {data}:")
    print(f"{gold}\n")
    data += 1
