t = int(input())

for _ in range(t):
    r, s = map(str, input().split())
    result = ''
    for i in range(len(s)):
        for j in range(int(r)):
            result += s[i]
    print(result)