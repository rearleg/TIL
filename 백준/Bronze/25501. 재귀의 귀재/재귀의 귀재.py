import sys


def is_palindrome(string, cnt=0):

    # 탈출 조건
    if len(string) <= 1:
        cnt += 1
        return 1, cnt

    if string[0] == string[-1]:
        cnt += 1
        return is_palindrome(string[1:-1], cnt)
    else:
        cnt += 1
        return 0, cnt


input = sys.stdin.readline

n = int(input())

for _ in range(n):
    s = input().rstrip()
    print(" ".join(map(str, is_palindrome(s))))
