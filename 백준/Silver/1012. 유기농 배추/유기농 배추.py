import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    # 격자 0으로 초기화
    arr = [[0] * M for _ in range(N)]
    # 격자 배추 심기
    for _ in range(K):
        x, y = map(int, input().split())
        arr[y][x] = 1

    # 지렁이 초기화
    worms = 0

    # 상하좌우
    dr = (-1, 1, 0, 0)
    dc = (0, 0, -1, 1)

    # 모두 한바퀴 돌면서 체크
    for r in range(N):
        for c in range(M):
            # arr[r][c]에 배추가 있다면 worms += 1
            if arr[r][c] == 1:
                worms += 1

                # 해당 좌표 스택에 넣기
                stack = [(r, c)]
                # 방문 처리
                arr[r][c] = 0

                while stack:
                    cur_r, cur_c = stack.pop()
                    # 상, 하, 좌, 우 살펴보기
                    for i in range(4):
                        new_r = cur_r + dr[i]
                        new_c = cur_c + dc[i]
                        # new_r, new_c가 범위에 있는지 확인 및 1인지 확인
                        if 0 <= new_r < N and 0 <= new_c < M and arr[new_r][new_c] == 1:
                            arr[new_r][new_c] = 0
                            stack.append((new_r, new_c))
    print(worms)
