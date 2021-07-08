def findonecheck(string, target):
    cnt=0
    for idx,var in enumerate(string):
        if var!=target[idx]:
            cnt+=1
        if cnt>1:
            return False
    return True
def bfs(begin, target, words):
    answer=0
    queue=[]
    visited=[False for _ in range(len(words))]
    queue.append(begin)
    while len(queue)!=0:
        answer+=1
        loop=len(queue)
        for i in range(loop):
            cur=queue.pop(0)
            for idx, var in enumerate(words):
                if findonecheck(cur, var) and visited[idx]==False:
                    visited[idx]=True
                    if var==target:
                        return answer
                    queue.append(var)
def solution(begin, target, words):
    answer = 0
    if not target in words:
        return 0
    answer=bfs(begin,target,words)
    return answer