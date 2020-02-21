import nltk
import json
import os

file = os.listdir('input/')
ps = nltk.stem.PorterStemmer()
doc = {}
punctuations = '''!()-[]{};:'"\,<>./?@#$%^&*_~1234567890'''
for file_name in file:
    with open('input/' + file_name, 'r') as cur_file:
        for line in cur_file:
            for word in line.split():
                found = False
                words = word.lower()
                for char in punctuations:
                    words = words.replace(char, '')
                words = ps.stem(words)
                if words not in doc:
                    doc.update({words: ([(file_name, 1)], 1)})
                else:
                    doc_list = doc.get(words)[0]
                    for i in range(0, len(doc_list)):
                        if file_name == doc_list[i][0]:
                            count = doc_list[i][1]
                            count = count + 1
                            doc_list[i] = (file_name, count)
                            found = True
                    if not found:
                        doc_list.append((file_name, 1))
                        num = doc.get(words)[1]
                        num = num + 1
                        doc[words] = (doc_list, num)
doc.update({'#Total_file': len(file)})
print(doc)
with open('inverted-index.json', 'w') as jfile:
    json.dump(doc, jfile)
