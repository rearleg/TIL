N = int(input())
P = int(input())
prices = []
if N >= 20:
    prices.append(P * 0.75)
    prices.append(P - 2000)
elif N >= 15:
    prices.append(P * 0.9)
    prices.append(P - 2000)
elif N >= 10:
    prices.append(P * 0.9)
    prices.append(P - 500)
elif N >= 5:
    prices.append(P - 500)
else:
    prices.append(P)

answer = int(min(prices))
if answer >= 0:
    print(answer)
else:
    print(0)