import sys

input = sys.stdin.readline

while True:
    h, l, w = map(int, input().split())
    if h == 0 and l == 0 and w == 0:
        break

    if h == 0:
        print(w // l, l, w)
    elif l == 0:
        print(h, w // h, w)
    else:
        print(h, l, h * l)
