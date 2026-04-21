import sys
L, A, B, C, D = map(int, sys.stdin.readlines())

if A / C > B / D:
    if A % C > 0:
        print(L - (A // C + 1))
    else:
        print(L - (A // C))
else:
    if B % D > 0:
        print(L - (B // D + 1))
    else:
        print(L - (B // D))
