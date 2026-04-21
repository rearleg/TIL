X = int(input())

k = 1
while k * (k + 1) // 2 < X:
    k += 1

prev_sum = (k - 1) * k // 2
offset = X - prev_sum

if k % 2:
    num = k - offset + 1
    den = offset
else:
    num = offset
    den = k - offset + 1

print(f"{num}/{den}")