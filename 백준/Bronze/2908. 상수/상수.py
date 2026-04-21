n, m = map(str, input().split())
print(max(int(n[::-1]), int(m[::-1])))