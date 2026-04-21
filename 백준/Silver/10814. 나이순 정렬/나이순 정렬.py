import sys

m = sys.stdin.readlines()[1:]

m.sort(key=lambda x: int(x.split()[0]))

print(''.join(m))