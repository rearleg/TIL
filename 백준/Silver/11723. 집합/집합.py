import sys
input = sys.stdin.readline

T = int(input())
S = []

for _ in range(T):
    cmd = input().strip()
    if cmd == 'all':
        S = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
    elif cmd == 'empty':
        S = []
    else:
        cmd1 = cmd.split()[0]
        x = int(cmd.split()[1])
        if cmd1 == 'add':
            if x not in S:
                S.append(x)
        elif cmd1 == 'remove':
            if x in S:
                S.remove(x)
        elif cmd1 == 'check':
            if x in S:
                print(1)
            else:
                print(0)
        elif cmd1 == 'toggle':
            if x in S:
                S.remove(x)
            else:
                S.append(x)
