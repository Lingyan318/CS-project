from neo4j.v1 import GraphDatabase, basic_auth
import sys
import io

# connection with authentication
# driver = GraphDatabase.driver("bolt://localhost", auth=basic_auth("neo4j", "cs1656"), encrypted=False)
# connection without authentication
file = open("output.txt", "w+", encoding='utf-8')
driver = GraphDatabase.driver("bolt://localhost", encrypted=False)
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf8')
session = driver.session()
transaction = session.begin_transaction()
#Q1
file.write('\n##### Q1 #####\n')
result = transaction.run("MATCH (a:Actor)-[:ACTS_IN]->(m:Movie) "
                         "RETURN a.name, count(*) as num "
                         "ORDER BY num DESC LIMIT 20;")
for record in result:
    file.write(str(record['a.name'])+','+str(record['num']) + "\n")
#Q2
file.write('\n##### Q2 #####\n')
result = transaction.run("MATCH (m:Movie)<-[r:RATED]-(:Person) with m, avg(r.stars) as star WHERE star<=3 RETURN  m.title;")
for record in result:
    file.write(str(record['m.title']) + "\n")
#Q3
file.write('\n##### Q3 #####\n')
result = transaction.run("MATCH (u:User)-[r:RATED]->(m:Movie), (a:Actor)-[:ACTS_IN]->(m) RETURN  m.title,count(a) as num ORDER BY num DESC LIMIT 1;")
for record in result:
    file.write(str(record['m.title']) + ','+str(record['num'])+"\n")
#Q4
file.write('\n##### Q4 #####\n')
result = transaction.run("MATCH (a:Actor)-[:ACTS_IN]->(m:Movie)<-[:DIRECTED]-(d:Director) with a,count(distinct d.name) as num where num >=3 return a.name,num;")
for record in result:
    file.write(str(record['a.name']) + '，' + str(record['num']) + "\n")
#Q5
file.write('\n##### Q5 #####\n')
result = transaction.run('match(a:Actor{name:"Kevin Bacon"})-[:ACTS_IN]->(m:Movie)<-[:ACTS_IN]-(a1:Actor)-[:ACTS_IN]->(:Movie)<-[:ACTS_IN]-(a2:Actor) return a2.name')
for record in result:
    file.write(str(record['a2.name']) + "\n")
#Q6
file.write('\n##### Q6 #####\n')
result = transaction.run("MATCH (d:Actor{name:'Tom Hanks'})-[:ACTS_IN]->(m:Movie) RETURN distinct m.genre;")
for record in result:
    file.write(str(record['m.genre']) + "\n")
#Q7
file.write('\n##### Q7 #####\n')
result = transaction.run("match (d:Director)-[:DIRECTED]->(m:Movie) with d, count(distinct m.genre) as num where num>=2 return d.name, num;")
for record in result:
    file.write(str(record['d.name']) + ", " + str(record['num']) + "\n")
#Q8
file.write('\n##### Q8 #####\n')
result = transaction.run('MATCH (a:Actor)-[:ACTS_IN]->(m:Movie)<-[:DIRECTED]-(d:Director) return a.name,d.name, count(*) as num ORDER BY num DESC LIMIT 5;')
for record in result:
    file.write(str(record['d.name']) + ", " + str(record['a.name']) + "," + str(record['num']) + "\n")

transaction.close()
session.close()