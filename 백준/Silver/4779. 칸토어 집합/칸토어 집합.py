import sys

def cantor(n):

    # 종료 조건
    if n == 0:
        return "-"

    # 이전 모양을 재귀로 호출
    prev = cantor(n - 1)

    # 사이의 공백 삽입
    space = " " * (3 ** (n - 1))  # 3의 n재곱으로 n - 1은 길이의 1/3이 됨

    # 패턴: 이전 모양 + 1/3만큼 길이의 공백 + 이전 모양
    return prev + space + prev


while True:
    try:
        line = sys.stdin.readline()
        if not line:
            break
        n = int(line)

        print(cantor(n))
    except:
        break
