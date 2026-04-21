check_list = [0] * 4
my_list = [0] * 4
check_secret = 0

# 함수 정의
def myadd(c):   # 새로 들어온 문자를 처리하는 함수
    global check_list, my_list, check_secret
    if c == 'A':
        my_list[0] += 1
        if my_list[0] == check_list[0]:
            check_secret += 1
    elif c == 'C':
        my_list[1] += 1
        if my_list[1] == check_list[1]:
            check_secret += 1
    elif c == 'G':
        my_list[2] += 1
        if my_list[2] == check_list[2]:
            check_secret += 1
    elif c == 'T':
        my_list[3] += 1
        if my_list[3] == check_list[3]:
            check_secret += 1


def myremove(c):    # 제거되는 문자를 처리하는 함수
    global check_list, my_list, check_secret
    if c == 'A':
        if my_list[0] == check_list[0]:
            check_secret -= 1
        my_list[0] -= 1
    elif c == 'C':
        if my_list[1] == check_list[1]:
            check_secret -= 1
        my_list[1] -= 1
    elif c == 'G':
        if my_list[2] == check_list[2]:
            check_secret -= 1
        my_list[2] -= 1
    elif c == 'T':
        if my_list[3] == check_list[3]:
            check_secret -= 1
        my_list[3] -= 1

# input 받기
S, P = map(int, input().split())
result = 0
A = list(input())
check_list = list(map(int, input().split()))

# check list에 0이 있는지 검사 = 0이 있으면 check_secret += 1
for i in range(4):
    if check_list[i] == 0:
        check_secret += 1

# 초기 P 부분 문자열 처리 부분
for i in range(P):
    myadd(A[i])

# 4 자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
if check_secret == 4:
    result += 1

for i in range(P, S):
    j = i - P
    myadd(A[i])
    myremove(A[j])
    if check_secret == 4:
        result += 1

print(result)