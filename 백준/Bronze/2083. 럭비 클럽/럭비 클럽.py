import sys

input = sys.stdin.readline

while True:
    cmd = list(map(str, input().split()))
    if cmd[0] == "#":
        break

    if int(cmd[1]) > 17 or int(cmd[2]) >= 80:
        print(cmd[0], "Senior")
    else:
        print(cmd[0], "Junior")
