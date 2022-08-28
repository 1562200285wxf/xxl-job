import re
n = int(input())
        sentence = []
        while 1:
        s = input()
        if s != "":
        sentence.append(s)
        else:
        break
        def is_num_leq_letter(pwd):
        num  = len(re.findall(r"\d",pwd))
        w = len(re.findall(r"[a-zA-Z]",pwd))
        if num<w:
        return True
        else:
        return False
        def five_continue(pwd):
        num  = len(re.findall(r"[a-zA-Z]{5,}",pwd))
        if num>0:
        return True
        else:
        return False

        def isContinuousChar(pwd):
        num  = len(re.findall(r"([a-zA-Z]|[0-9])\1",pwd))
        if num>0:
        return True
        else:
        return False

        for s in sentence:
        if len(s)>=6 and is_num_leq_letter(s) and not five_continue(s) and not isContinuousChar(s):
        print('YES')
        else:
        print('NO')
        print()

