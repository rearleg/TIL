import sys

input = sys.stdin.readline

n, m = map(int, input().split())
lst = []
for _ in range(n):
    lst.append(input().rstrip())

pokemon_num = {i: v for i, v in enumerate(lst, start=1)}
pokemon_name = {v: i for i, v in enumerate(lst, start=1)}


for _ in range(m):
    cmd = input().rstrip()
    if cmd.isdigit():
        print(pokemon_num[int(cmd)])
    else:
        print(pokemon_name[cmd])
