n = int(input())
rainbow = ["ChongChong"]

for _ in range(n):
    dance = list(input().split())
    if dance[0] in rainbow and dance[1] in rainbow:
        pass
    elif dance[0] in rainbow:
        rainbow.append(dance[1])
    elif dance[1] in rainbow:
        rainbow.append(dance[0])

print(len(rainbow))