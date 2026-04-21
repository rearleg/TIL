import sys

input = sys.stdin.readline

n = int(input())

# 0부터 10000까지의 수를 담을 수 있는 리스트를 만든다.
cnt_l = [0] * 10001

# 입력값을 받는 즉시 따로 저장하지 않고(메모리 절약) cnt_l에 업데이트한다.
for _ in range(n):
    n = int(input())
    cnt_l[n] += 1

# cnt_l을 순회하며 0이 아닌 값이 있는 경우 출력한다.
for i in range(10001):
    if cnt_l[i] != 0:
        for _ in range(cnt_l[i]):
            print(i)
