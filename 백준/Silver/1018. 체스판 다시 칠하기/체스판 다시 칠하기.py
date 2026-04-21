n, m = map(int, input().split())
boardW = [["W", "B", "W", "B", "W", "B", "W", "B"], ["B", "W", "B", "W", "B", "W", "B", "W"], ["W", "B", "W", "B", "W", "B", "W", "B"], ["B", "W", "B", "W", "B", "W", "B", "W"], ["W", "B", "W", "B", "W", "B", "W", "B"], ["B", "W", "B", "W", "B", "W", "B", "W"], ["W", "B", "W", "B", "W", "B", "W", "B"], ["B", "W", "B", "W", "B", "W", "B", "W"]]
boardB = [["B", "W", "B", "W", "B", "W", "B", "W"], ["W", "B", "W", "B", "W", "B", "W", "B"], ["B", "W", "B", "W", "B", "W", "B", "W"], ["W", "B", "W", "B", "W", "B", "W", "B"], ["B", "W", "B", "W", "B", "W", "B", "W"], ["W", "B", "W", "B", "W", "B", "W", "B"], ["B", "W", "B", "W", "B", "W", "B", "W"], ["W", "B", "W", "B", "W", "B", "W", "B"]]

board = []
for _ in range(n):
    board.append(list(input()))

answer = 64

for a in range(n - 7):
    for b in range(m - 7):
        cntW = 0
        cntB = 0
        for i in range(8):
            for j in range(8):
                if board[a+i][b+j] != boardW[i][j]:
                    cntW += 1
                if board[a+i][b+j] != boardB[i][j]:
                    cntB += 1
        answer = min(answer, cntW, cntB)

print(answer)