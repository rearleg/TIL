import sys

n = sys.stdin.readlines()[1:]

n.sort(key=lambda x: (int(x.split()[0]), (int(x.split()[1]))))

print(''.join(n))