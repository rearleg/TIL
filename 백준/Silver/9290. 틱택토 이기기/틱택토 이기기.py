import sys

input = sys.stdin.readline

T = int(input())
CASE = 1
for _ in range(T):

    board = [list(input().rstrip()) for _ in range(3)]
    player = input().rstrip()
    answer = None

    win = (
        [(0, 0), (0, 1), (0, 2)],
        [(1, 0), (1, 1), (1, 2)],
        [(2, 0), (2, 1), (2, 2)],
        [(0, 0), (1, 0), (2, 0)],
        [(0, 1), (1, 1), (2, 1)],
        [(0, 2), (1, 2), (2, 2)],
        [(0, 0), (1, 1), (2, 2)],
        [(0, 2), (1, 1), (2, 0)],
    )

    for i in range(3):
        for j in range(3):
            if board[i][j] == "-":
                board[i][j] = player
                won = False
                for l in win:
                    if (
                        board[l[0][0]][l[0][1]] == player
                        and board[l[1][0]][l[1][1]] == player
                        and board[l[2][0]][l[2][1]] == player
                    ):
                        won = True
                        break
                if won:
                    answer = [row[:] for row in board]
                    break

                board[i][j] = "-"
        if answer is not None:
            break

    print(f"Case {CASE}:")
    for i in range(3):
        print("".join(answer[i]))
    CASE += 1
