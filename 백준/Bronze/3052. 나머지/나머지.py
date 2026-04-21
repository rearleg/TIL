lst_1 = [int(input()) for _ in range(10)]
lst_2 = []

for i in lst_1:
    n = i % 42
    lst_2.append(n)

unique = list(set(lst_2))
print(len(unique))