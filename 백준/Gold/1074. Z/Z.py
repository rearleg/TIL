import sys
input = sys.stdin.readline

N, r, c = map(int, input().split())

def quadrant(n, r, c):
    if n == 0:
        return 0
    
    half = 2 ** (n - 1)
    area = half * half
    
    # 사분면 위치 파악
    q = 0
    if r >= half:
        # 오른쪽이면 +2
        q += 2
        r -= half
        # 아래쪽이면 +1
    if c >= half:
        q += 1
        c -= half
    
    # 에어리어 당 지나온 갯수 + 재귀
    return (area * q) + quadrant(n - 1, r , c)

print(quadrant(N, r, c))