import sys

input = sys.stdin.readline

s = input().rstrip()
rot = ""

for ch in s:
    if ch.isalpha():
        temp = ord(ch)
        # 대문자라면
        if temp - ord("a") < 0:
            x = temp + 13
            if x > ord("Z"):
                x -= 26
                rot = rot + chr(x)
            else:
                rot = rot + chr(x)
        # 소문자라면
        else:
            x = temp + 13
            if x > ord("z"):
                x -= 26
                rot = rot + chr(x)
            else:
                rot = rot + chr(x)
    else:
        rot = rot + ch

print(rot)