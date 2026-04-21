import sys

input = sys.stdin.readline

choco_kind = ["H", "T", "C", "K", "G"]
choco = {}
choco["H"], choco["T"], choco["C"], choco["K"], choco["G"] = map(int, input().split())

total = sum(choco.values())
M = int(input())
base = int(str(total)[-1])
if base == 0 or base == 1:
    base = 10
for _ in range(M):
    eat = list(map(int, input().split()))
    total_based = ""

    for i in range(5):
        choco[choco_kind[i]] -= eat[i]

    total = sum(choco.values())
    a = total
    while a:
        total_based = str(a % base) + total_based
        a //= base
    if not total_based:
        total_based = "0"
    print(f"{total_based}7H")
    base = int(str(total)[-1])
    if base == 0 or base == 1:
        base = 10

    if total <= 0:
        print("NULL")
        continue

    choco_rank = sorted(choco.items(), key=lambda x: (-x[1], x[0]))
    for line in choco_rank:
        if line[1] != 0:
            print(line[0], end="")
    print()
