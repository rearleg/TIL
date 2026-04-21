h, m = map(int, input().split())
t = int(input())
h += (m + t) // 60
m = (m + t) % 60
if h >= 24:
    h -= 24
print(h, m)