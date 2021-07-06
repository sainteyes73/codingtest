answer=0
def dfs(numbers, target, idx, res):
    global answer
    if target==res and len(numbers)==idx:
        answer=answer+1
        return
    elif len(numbers)==idx:
        return
    else:
        dfs(numbers,target,idx+1,res+numbers[idx])
        dfs(numbers,target,idx+1,res-numbers[idx])
def solution(numbers, target):
    global answer
    dfs(numbers,target,0,0)
    return answer

