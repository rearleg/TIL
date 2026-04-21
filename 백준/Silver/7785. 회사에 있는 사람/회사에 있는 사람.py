n = int(input())
S = set()
for _ in range(n):
    cmd = list(input().split())
    if cmd[1] == "enter":
        S.add(cmd[0])
    elif cmd[1] == "leave":
        S.remove(cmd[0])

print("\n".join(map(str, sorted(S, reverse=True))))
