def bfs(map,i,j):
    q=[]
    dy=[-1,1,0,0]
    dx=[0,0,-1,1]
    count=1
    q.append([i,j])
    map[i][j]=1
    while len(q)>0:
        cur=q.pop(0)
        cur_y=cur[0]
        cur_x=cur[1]
        for i in range(4):
            yy=cur_y+dy[i]

            xx=cur_x+dx[i]
            if 0<=yy<len(map) and 0<=xx<len(map[0]) and map[yy][xx]!=1:
                q.append([yy, xx])
                count+=1
                map[yy][xx]=1
    return count

def solution(M,N,tile):#M은 y N은 x 0244 -> 왼쪽 아래 꼭지점 xy 오른쪽 위 꼭지점 xy 1125 4062
    map=[[0]*N for _ in range(M)]
    for i in range(tile):
        temp=input().split()
        x=int(temp[0])
        y=int(temp[1])
        xx=int(temp[2])
        yy=int(temp[3])
        for j in range(yy-y):
            for k in range(xx-x):
                map[M-yy+j][x+k]=1
    result=[]
    for i in range(M):
        for j in range(N):
            if map[i][j]==0:
                result.append(bfs(map,i,j))
    result=sorted(result)
    print(len(result))
    for i in result:
        print(i, end='')
        print(" ", end='')

temp=input().split()
M=int(temp[0])
N=int(temp[1])
tile=int(temp[2])
solution(M,N,tile)