n = int(input())

for _ in range(n):
    h, w, p = map(int, input().split())
    floor = p % h
    room = p // h + 1
    if floor == 0:
        floor = h
        room -= 1
    print(floor*100+room)