import sqlite3 as lite
import csv
import re
import pandas
con = lite.connect('cs1656.sqlite')

with con:
    cur = con.cursor()

    ########################################################################
    ### CREATE TABLES ######################################################
    ########################################################################
    # DO NOT MODIFY - START
    cur.execute('DROP TABLE IF EXISTS Actors')
    cur.execute("CREATE TABLE Actors(aid INT, fname TEXT, lname TEXT, gender CHAR(6), PRIMARY KEY(aid))")

    cur.execute('DROP TABLE IF EXISTS Movies')
    cur.execute("CREATE TABLE Movies(mid INT, title TEXT, year INT, rank REAL, PRIMARY KEY(mid))")

    cur.execute('DROP TABLE IF EXISTS Directors')
    cur.execute("CREATE TABLE Directors(did INT, fname TEXT, lname TEXT, PRIMARY KEY(did))")

    cur.execute('DROP TABLE IF EXISTS Cast')
    cur.execute("CREATE TABLE Cast(aid INT, mid INT, role TEXT)")

    cur.execute('DROP TABLE IF EXISTS Movie_Director')
    cur.execute("CREATE TABLE Movie_Director(did INT, mid INT)")
    # DO NOT MODIFY - END

    ########################################################################
    ### READ DATA FROM FILES ###############################################
    ########################################################################
    # actors.csv, cast.csv, directors.csv, movie_dir.csv, movies.csv
    # UPDATE THIS
    actors = []
    with open('actors.csv') as actor_file:
        reader = csv.reader(actor_file)
        for row in reader:
            cur.execute("INSERT INTO Actors VALUES( " + row[0] + ", '" + row[1] + "', '" + row[2] + "', '" + row[3] + "')")
    cast = []
    with open('cast.csv') as cast_file:
        reader = csv.reader(cast_file)
        for row in reader:
            cur.execute("INSERT INTO Cast VALUES(" + row[0] + ", " + row[1] + ", '" + row[2] + "')")

    directors = []
    with open('directors.csv') as directors_file:
        reader = csv.reader(directors_file)
        for row in reader:
            cur.execute("INSERT INTO Directors VALUES(" + row[0] + ", '" + row[1] + "', '" + row[2] + "')")

    movie_dir = []
    with open('movie_dir.csv') as movie_dir_file:
        reader = csv.reader(movie_dir_file)
        for row in reader:
            cur.execute("INSERT INTO Movie_Director VALUES(" + row[0] + ", " + row[1] + ")")

    movies = []
    with open('movies.csv') as movies_file:
        reader = csv.reader(movies_file)
        for row in reader:
            cur.execute("INSERT INTO Movies VALUES(" + row[0] + ", '" + row[1] + "', " + row[2] + ", " + row[3] + ")")

    ########################################################################
    ### INSERT DATA INTO DATABASE ##########################################
    ########################################################################
    # UPDATE THIS TO WORK WITH DATA READ IN FROM CSV FILES
    ''' 
    cur.execute("INSERT INTO Actors VALUES(1001, 'Harrison', 'Ford', 'Male')")
    cur.execute("INSERT INTO Actors VALUES(1002, 'Daisy', 'Ridley', 'Female')")

    cur.execute("INSERT INTO Movies VALUES(101, 'Star Wars VII: The Force Awakens', 2015, 8.2)")
    cur.execute("INSERT INTO Movies VALUES(102, 'Rogue One: A Star Wars Story', 2016, 8.0)")

    cur.execute("INSERT INTO Cast VALUES(1001, 101, 'Han Solo')")
    cur.execute("INSERT INTO Cast VALUES(1002, 101, 'Rey')")

    cur.execute("INSERT INTO Directors VALUES(5000, 'J.J.', 'Abrams')")

    cur.execute("INSERT INTO Movie_Director VALUES(5000, 101)")

    con.commit()
    '''

    ########################################################################
    ### QUERY SECTION ######################################################
    ########################################################################
    queries = {}

    # DO NOT MODIFY - START
    # DEBUG: all_movies ########################
    queries['all_movies'] = '''
SELECT * FROM Movies
'''
    # DEBUG: all_actors ########################
    queries['all_actors'] = '''
SELECT * FROM Actors
'''
    # DEBUG: all_cast ########################
    queries['all_cast'] = '''
SELECT * FROM Cast
'''
    # DEBUG: all_directors ########################
    queries['all_directors'] = '''
SELECT * FROM Directors
'''
    # DEBUG: all_movie_dir ########################
    queries['all_movie_dir'] = '''
SELECT * FROM Movie_Director
'''
    # DO NOT MODIFY - END

    ########################################################################
    ### INSERT YOUR QUERIES HERE ###########################################
    ########################################################################
    # NOTE: You are allowed to also include other queries here (e.g.,
    # for creating views), that will be executed in alphabetical order.
    # We will grade your program based on the output files q01.csv,
    # q02.csv, ..., q12.csv

    # Q01 ########################
    queries['q01'] = '''
SELECT a.fname, a.lname
FROM Cast AS c
INNER JOIN Actors AS a ON c.aid = a.aid
WHERE c.aid in (SELECT c.aid FROM Cast AS c INNER JOIN Movies AS m ON m.mid = c.mid WHERE m.year <= 1999 AND m.year >= 1990)
AND c.aid in (SELECT c.aid FROM Cast AS c INNER JOIN Movies AS m ON m.mid = c.mid WHERE m.year > 2009)
GROUP BY c.aid;
'''

    # Q02 ########################
    queries['q02'] = '''
SELECT m.title, year
FROM Movies m
WHERE year IN (SELECT year FROM Movies WHERE title = "Star Wars VII: The Force Awakens")
AND rank > (SELECT rank FROM Movies WHERE title = "Star Wars VII: The Force Awakens" LIMIT 1)
ORDER BY m.title ASC;
'''

    # Q03 ########################
    queries['q03'] = '''
select a.fname, a.lname,count(DISTINCT c.mid) as num
from Actors a
INNER JOIN Cast c on c.aid = a.aid
INNER JOIN Movies m on c.mid = m.mid
where m.title like '%Star Wars%'
group by a.aid
order by num desc;
'''

    # Q04 ########################
    queries['q04'] = '''
SELECT a.fname, a.lname
FROM Actors AS a
WHERE NOT a.aid IN 
(SELECT a2.aid
FROM Actors AS a2
INNER JOIN Cast AS c2 ON a2.aid = c2.aid
INNER JOIN Movies AS m2 ON m2.mid = c2.mid
WHERE m2.year > 1987)
order by a.fname and a.lname asc;
'''

    # Q05 ########################
    queries['q05'] = '''
SELECT d.fname, d.lname, COUNT(DISTINCT md.mid) AS num
FROM Directors as d
INNER JOIN Movie_Director as md ON d.did = md.did
GROUP BY d.did
ORDER BY num DESC
LIMIT 20;
'''

    # Q06 ########################
    queries['q06'] = '''
SELECT m.title, COUNT(DISTINCT c.aid) AS num
FROM Movies AS m INNER JOIN Cast AS c ON c.mid = m.mid
GROUP BY m.mid
HAVING num >= (SELECT MIN(num2)
FROM (SELECT COUNT(c2.aid) AS num2
FROM Movies AS m2
INNER JOIN Cast AS c2 ON c2.mid = m2.mid
GROUP BY m2.mid
ORDER BY num2 DESC
LIMIT 20))
ORDER BY num DESC
'''

    # Q07 ########################
    queries['q07'] = '''
SELECT MCount.title, MCount.F, MCount.M
FROM ((SELECT Mgender.title, SUM(CASE WHEN Mgender.gender = "Female" THEN 1 ELSE 0 END) AS F, SUM(CASE WHEN Mgender.gender = "Male" THEN 1 ELSE 0 END) AS M
FROM (SELECT m1.title AS title, Actors.gender AS gender
FROM Actors, Movies INNER JOIN Cast c1 on c1.aid = Actors.aid INNER JOIN Movies m1 on c1.mid = m1.mid
GROUP BY fname, lname, m1.title) as Mgender
GROUP BY Mgender.title) as MCount)
WHERE MCount.F > MCount.M
order by MCount.title asc;
'''

    # Q08 ########################
    queries['q08'] = '''
SELECT a.fname, a.lname, COUNT(DISTINCT md.did) AS num
FROM Actors AS a INNER JOIN Cast AS c ON a.aid = c.aid INNER JOIN Movie_Director AS md ON c.mid = md.mid
GROUP BY a.aid HAVING num > 5
AND a.aid IN (SELECT a2.aid FROM Actors AS a2 INNER JOIN Cast AS c2 ON c2.aid = a2.aid INNER JOIN Movies AS m2 ON m2.mid = c2.mid
GROUP BY a2.aid
HAVING COUNT(DISTINCT m2.mid) > 5)
ORDER BY num DESC;
'''

    # Q09 ########################
    queries['q09'] = '''
SELECT a.fname, a.lname, COUNT(m.mid) as num
FROM Actors AS a INNER JOIN Cast AS c ON a.aid = c.aid INNER JOIN Movies AS m ON c.mid = m.mid
WHERE SUBSTR(a.fname, 1, 1) = 'S'
AND m.mid IN (SELECT m2.mid FROM Actors AS a2 INNER JOIN Cast AS c2 ON a2.aid = c2.aid INNER JOIN Movies AS m2 ON c2.mid = m2.mid
WHERE m.year = (SELECT MIN(m3.year)
FROM Actors AS a3 INNER JOIN Cast AS c3 ON a3.aid = c3.aid INNER JOIN Movies AS m3 ON c3.mid = m3.mid
WHERE a3.aid = a.aid))
GROUP BY a.aid
ORDER BY num DESC;
'''

    # Q10 ########################
    queries['q10'] = '''
SELECT *
FROM (Actors AS a INNER JOIN Cast AS c ON a.aid = c.aid INNER JOIN Movies AS m ON c.mid = m.mid
INNER JOIN Movie_Director AS md ON c.mid = md.mid INNER JOIN Directors AS d ON d.did = md.did)
WHERE a.lname = d.lname
ORDER BY a.lname;
'''

    # Q11 ########################
    queries['q11'] = '''
WITH Cast1 AS(Select c.aid, c.mid, 0 as level FROM Cast c Join Actors A on A.aid=c.aid Where A.fname='Tom' and A.lname='Hanks'
Union all select c1.aid, c2.mid , c.level + 1 from Cast1 c join Cast c1 on c1.mid= c.mid AND c.level<2 JOIN Cast c2 on c1.aid = c2.aid)
select a.fname, a.lname
from actors a
where a.aid in (SELECT c.aid from Cast1 c GROUP BY c.aid having c.level= 2)
ORDER BY a.fname,a.lname ASC;
'''

    # Q12 ########################
    queries['q12'] = '''
SELECT a.fname, a.lname, COUNT(m.mid), AVG(m.rank)
FROM (Actors AS a INNER JOIN Cast AS c ON a.aid = c.aid INNER JOIN Movies AS m ON c.mid = m.mid)
GROUP BY a.aid
ORDER BY AVG(m.rank) DESC
LIMIT 20;
'''

    ########################################################################
    ### SAVE RESULTS TO FILES ##############################################
    ########################################################################
    # DO NOT MODIFY - START
    for (qkey, qstring) in sorted(queries.items()):
        try:
            cur.execute(qstring)
            all_rows = cur.fetchall()

            print("=========== ", qkey, " QUERY ======================")
            print(qstring)
            print("----------- ", qkey, " RESULTS --------------------")
            for row in all_rows:
                print(row)
            print(" ")

            save_to_file = (re.search(r'q0\d', qkey) or re.search(r'q1[012]', qkey))
            if (save_to_file):
                with open(qkey + '.csv', 'w') as f:
                    writer = csv.writer(f)
                    writer.writerows(all_rows)
                    f.close()
                print("----------- ", qkey + ".csv", " *SAVED* ----------------\n")

        except lite.Error as e:
            print("An error occurred:", e.args[0])
	
