
def dfs(map,i,j,size):
    map[i][j]=0
    count=1
    dy=[-1,1,0,0]
    dx=[0,0,-1,1]
    for d in range(4):
        yy=dy[d]+i
        xx=dx[d]+j
        if 0<=yy<size and 0<=xx<size and map[yy][xx]!=0:
            count+=dfs(map,yy,xx,size)

    return count
def solution(map,size):
    result=[]
    for i in range(size):
        for j in range(size):
            if map[i][j]==1:
                result.append(dfs(map,i,j,size))

    print(len(result))
    result=sorted(result)
    for i in result:
        print(i)


size=int(input())
map=[[]*size for _ in range(size)]
for i in range(size):
    temp=input()
    for j in range(size):
        map[i].append(int(temp[j]))

solution(map,size)