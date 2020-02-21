import math
import nltk
import json

def weighted(value, N, n):
    w = (1 + math.log2(value)) * math.log2(N / n)
    return w


with open('inverted-index.json', 'r') as jsonfile:
    doc = json.load(jsonfile)
N = doc.get('#Total_file')
ps = nltk.stem.PorterStemmer()
kw = []
with open('keywords.txt', 'r') as key:
    for line in key:
        t = ()
        for word in line.split():
            t += ((word.replace('\n', '').lower()),)
        kw.append(t)
for m in range(0, len(kw)):
    doc_sort = {}
    doc_list = {}
    found = False
    r = 0
    print('----------------------------')
    print('keywords = ', end=' ')
    for key in kw[m]:
        print(key, end=' ')
    for k in kw[m]:
        k = ps.stem(k)
        c = doc.get(k)
        n = c[1]
        for d in c[0]:
            name = d[0]
            w = weighted(d[1],N,n)
            if name in doc_list:
                d = doc_list.get(name)
                d.append((k, w))
            else:
                doc_list.update({name: [(k, w)]})
    for k1 in doc_list:
        sum = 0
        c = doc_list.get(k1)
        for i in c:
            sum = sum + i[1]
        c.insert(0, sum)
        doc_list.update({k1: c})
    file_sort = sorted(doc_list.items(), key=lambda keyword: keyword[1][0], reverse=True)
    for k2 in file_sort:
        if k2[1][0] not in doc_sort:
            doc_sort.update({k2[1][0]:[k2[0]]})
        else:
            c = doc_sort.get(k2[1][0])
            c.append(k2[0])
            doc_sort.update({k2[1][0]:c})
    while not found:
        for k3 in doc_sort:
            c = doc_sort.get(k3)
            for k4 in c:
                for k5 in file_sort:
                    if (k4 == k5[0]):
                        r = r + 1
                        print()
                        print('[%s] file=%s score=%.6f' % (r, k5[0], k5[1][0]))
                        for k6 in kw[m]:
                            for k7 in range(1, len(k5[1])):
                                if k5[1][k7][0] == ps.stem(k6):
                                    print('    weight(%s)=%.6f' % (k6, k5[1][k7][1]))
                                    found = True