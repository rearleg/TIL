import sys

input = sys.stdin.readline

n = int(input())
org = input().rstrip()
fch = input().rstrip()

is_succes = True

if n % 2 == 0:
    if org != fch:
        is_succes = False
else:
    for i in range(len(org)):
        if org[i] == fch[i]: 
            is_succes = False
            break

if is_succes:
    print("Deletion succeeded")
else:
    print("Deletion failed")