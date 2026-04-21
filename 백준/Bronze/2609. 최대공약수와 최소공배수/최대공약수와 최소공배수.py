n, m = map(int, input().split())
lst = []

for i in range(1, min(n, m)+1):
    if n % i == 0 and m % i == 0:
        lst.append(i)

lst.sort(reverse=True)
gcd = lst[0]
lcm = (n * m) / gcd
print(gcd)
print(int(lcm))