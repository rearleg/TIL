A = int(input())
B = int(input())
C = int(input())

n = str(A * B * C)

for i in range(10):
    check = str(i)
    print(n.count(check))
