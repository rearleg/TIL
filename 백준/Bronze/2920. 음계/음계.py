lst = list(map(int, input().split()))
asc = [1, 2, 3, 4, 5, 6, 7, 8]
dec = [8, 7, 6, 5, 4, 3, 2, 1]

if lst == asc:
    print('ascending')
elif lst == dec:
    print('descending')
else:
    print('mixed')