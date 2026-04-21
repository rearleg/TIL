import sys

input = sys.stdin.readline

N = int(input())
switch = list(map(int, input().split()))
S = int(input())
for _ in range(S):
    s, n = map(int, input().split())
    # 남학생이라면
    if s == 1:
        for i in range(len(switch)):
            # 남학생이 받은 번호의 배수라면
            if (i + 1) % n == 0:
                # 1이라면
                if switch[i] == 1:
                    switch[i] = 0
                # 0이라면
                else:
                    switch[i] = 1

    elif s == 2:
        n -= 1
        s = n - 1
        e = n + 1
        while s >= 0 and e < N and switch[s] == switch[e]:
            s -= 1
            e += 1
        for i in range(s + 1, e):
            switch[i] ^= 1

for i in range(0, N, 20):
    print(*switch[i : i + 20])