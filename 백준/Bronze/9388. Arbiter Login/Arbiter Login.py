import sys

input = sys.stdin.readline

T = int(input())
CASE = 1

for _ in range(T):
    lst = list(map(str, input().rstrip().split()))
    if lst[0] == lst[1]:
        print(f"Case {CASE}: Login successful.")
        CASE += 1
    else:
        caps = ""
        for ch in lst[0]:
            if ch.isalpha() and ord(ch) >= ord("a"):
                caps = caps + chr(ord(ch) - 32)
            elif ch.isalpha() and ord(ch) < ord("a"):
                caps = caps + chr(ord(ch) + 32)
            else:
                caps = caps + ch

        if caps == lst[1]:
            print(f"Case {CASE}: Wrong password. Please, check your caps lock key.")
            CASE += 1
            continue

        num = ""

        for ch in lst[0]:
            if ch.isalpha():
                num = num + ch

        if num == lst[1]:
            print(f"Case {CASE}: Wrong password. Please, check your num lock key.")
            CASE += 1
            continue

        caps_num = ""
        for ch in num:
            if ch.isalpha() and ord(ch) >= ord("a"):
                caps_num = caps_num + chr(ord(ch) - 32)
            else:
                caps_num = caps_num + chr(ord(ch) + 32)

        if caps_num == lst[1]:
            print(
                f"Case {CASE}: Wrong password. Please, check your caps lock and num lock keys."
            )
            CASE += 1
        else:
            print(f"Case {CASE}: Wrong password.")
            CASE += 1