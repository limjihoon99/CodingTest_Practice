def solution(name, yearning, photo):
    answer = []

    dic = dict(zip(name, yearning))
    for i in photo:
        answer.append(sum([dic[j] for j in i if j in dic]))

    return answer