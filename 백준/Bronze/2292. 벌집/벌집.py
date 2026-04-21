n = int(input())
layer, val = 1, 1
while n > val:
    val += 6 * layer
    layer += 1

print(layer)