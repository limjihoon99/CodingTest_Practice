def solution(k, m, score):
    
    result = 0
    score.sort(reverse=True)
    
    for i in range(len(score)//m):
        box = score[m*i:m*(i+1)]
        
        result += box[-1] * m
        
    return result