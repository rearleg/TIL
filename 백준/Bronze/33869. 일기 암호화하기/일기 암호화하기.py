W = list(input())
S = list(input())
password = []
answer = ""
alphabet = [
    "A",
    "B",
    "C",
    "D",
    "E",
    "F",
    "G",
    "H",
    "I",
    "J",
    "K",
    "L",
    "M",
    "N",
    "O",
    "P",
    "Q",
    "R",
    "S",
    "T",
    "U",
    "V",
    "W",
    "X",
    "Y",
    "Z",
]

# 중복제거
for i in W:
    if i not in password:
        password.append(i)

# 채우기
for i in alphabet:
    if i not in password:
        password.append(i)

for ch in S:
    a = ord(ch) - ord("A")
    answer = answer + password[a]

print(answer)
