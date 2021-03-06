INSERT INTO FOREST VALUES ( '1', 'Allegheny National Forest', 40000.0, 0.3, 134.0, 550.0, 233.0, 598.0);
INSERT INTO FOREST VALUES ( '2', 'Pennsylvania Forest', '10000.0', '0.75', '21.0', '100.0', '35.0', '78.0');
INSERT INTO FOREST VALUES ( '3', 'Stone Valley',	'15000.0', '0.4', '22.0', '78.0', '12.0', '20.0');
INSERT INTO FOREST VALUES ( '4', 'Garrett State Forest', 19000.0, 0.8, 112.0, 138.0, 172.0, 190.0);
INSERT INTO FOREST VALUES ( '5', 'Potomac State Forest', 9000.0, 0.9, 75.0, 190.0, 119.0, 127.0);

INSERT INTO STATE VALUES ( 'Pennsylvania', 'PA', 50000.0, 1400000 );
INSERT INTO STATE VALUES ( 'Ohio', 'OH', 45000.0, 1200000 );
INSERT INTO STATE VALUES ( 'Virginia', 'VA', 35000.0, 1000000 );
INSERT INTO STATE VALUES ( 'New York', 'NY', 55000.0, 1100000 );
INSERT INTO STATE VALUES ( 'Maryland', 'MD',	59000.0, 1700000 );
INSERT INTO STATE VALUES ( 'New Jersey', 'NJ', 39000.0, 1900000 );

INSERT INTO COVERAGE VALUES ( '1', 'PA', 0.4, 16000.0 );
INSERT INTO COVERAGE VALUES ( '1', 'OH', 0.6, 24000.0 );
INSERT INTO COVERAGE VALUES ( '2', 'PA', 1, 10000.0 );
INSERT INTO COVERAGE VALUES ( '3', 'PA', 0.3, 4500.0 );
INSERT INTO COVERAGE VALUES ( '3', 'VA', 0.6, 9000.0 );
INSERT INTO COVERAGE VALUES ( '3', 'OH', 0.1, 1500.0 );
INSERT INTO COVERAGE VALUES ( '4', 'MD', 1, 19000.0 );
INSERT INTO COVERAGE VALUES ( '5', 'MD', 1, 9000.0 );

INSERT INTO ROAD VALUES ( '1', 'FORBES', 500.0 );
INSERT INTO ROAD VALUES ( '2', 'BIGELOW', 300.0 );
INSERT INTO ROAD VALUES ( '3', 'BAYARD', 100.0 );

INSERT INTO INTERSECTION VALUES ( '1', '1' );
INSERT INTO INTERSECTION VALUES ( '1', '2' );
INSERT INTO INTERSECTION VALUES ( '2', '1' );
INSERT INTO INTERSECTION VALUES ( '2', '2' );
INSERT INTO INTERSECTION VALUES ( '3', '3' );
INSERT INTO INTERSECTION VALUES ( '4', '2' );
INSERT INTO INTERSECTION VALUES ( '4', '3' );
INSERT INTO INTERSECTION VALUES ( '5', '1' );
INSERT INTO INTERSECTION VALUES ( '5', '3' );

INSERT INTO WORKER VALUES( '123456789', 'John', 22, 3 );
INSERT INTO WORKER VALUES( '121212121', 'Jason', 30, 5 );
INSERT INTO WORKER VALUES( '222222222', 'Mike', 25, 4 );
INSERT INTO WORKER VALUES( '555555555', 'Tom', 35, 1 );
INSERT INTO WORKER VALUES( '777777777', 'Mary', 27, 7 );

INSERT INTO SENSOR VALUES ( 1, 150.0, 300.0, to_date('01-JAN-2017 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 2, '123456789' );
INSERT INTO SENSOR VALUES ( 2, 200.0, 400.0, to_date('01-JAN-2017 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 3, '123456789' );
INSERT INTO SENSOR VALUES ( 3, 50.0, 50.0, to_date('01-JAN-2017 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 3, '123456789' );
INSERT INTO SENSOR VALUES ( 4, 50.0, 15.0, to_date('01-JAN-2017 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 3, NULL );
INSERT INTO SENSOR VALUES ( 5, 60.0, 60.0, to_date('01-JAN-2017 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 4, '121212121' );
INSERT INTO SENSOR VALUES ( 6, 50.0, 60.0, to_date('01-JAN-2018 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 3, NULL );
INSERT INTO SENSOR VALUES ( 7, 150.0, 310.0, to_date('01-MAR-2017 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 3, '222222222' );
INSERT INTO SENSOR VALUES ( 8, 60.0, 50.0, to_date('01-MAR-2018 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 4, '121212121' );
INSERT INTO SENSOR VALUES ( 9, 115.0, 173.0, to_date('10-MAR-2017 10:00:00',  'DD-MON-YYYY HH24:MI:SS'), 3, '777777777' );
INSERT INTO SENSOR VALUES ( 10, 80.0, 120.0, to_date('01-MAR-2018 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 3, '121212121' );


INSERT INTO REPORT VALUES( 1, 55, to_date('10-JAN-2017 09:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 1, 57, to_date('10-JAN-2017 14:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 1, 40, to_date('10-JAN-2017 20:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 2, 58, to_date('10-JAN-2017 12:30:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 2, 59, to_date('10-JAN-2018 12:30:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 3, 50, to_date('10-JAN-2017 12:30:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 4, 30, to_date('01-JAN-2017 22:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 5, 33, to_date('02-JAN-2017 22:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 5, 38, to_date('02-JAN-2018 22:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 6, 39, to_date('10-MAR-2017 12:30:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 7, 45, to_date('20-SEP-2017 22:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 7, 50, to_date('20-FEB-2018 22:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 8, 57, to_date('02-JAN-2018 22:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 9, 50, to_date('20-SEP-2017 21:00:00', 'DD-MON-YYYY HH24:MI:SS') );
INSERT INTO REPORT VALUES( 10, 51, to_date('02-MAR-2017 23:00:00', 'DD-MON-YYYY HH24:MI:SS') );

