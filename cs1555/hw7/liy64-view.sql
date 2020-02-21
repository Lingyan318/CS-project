--ling yan
--liy64

@hw7-db
--1
--a
drop view duties;
create view duties 
as select name, count(sensor_id) as count
from (worker w join sensor s on s.maintainer = w.ssn)
group by name;

--b
drop MATERIALIZED view duties_mv;
create MATERIALIZED view duties_mv(name, count) 
	build immediate 
	refresh complete on demand
	as select name,count(sensor_id) as count
	from (worker join sensor on maintainer = ssn) 
	group by name;
	
--c
drop view forest_sensor;
create view forest_sensor
	as select forest_no, name, sensor_id
	from forest f join sensor s 
	on f.mbr_xmin < s.x and s.x < f.mbr_xmax and f.mbr_ymin < s.y and s.y < f.mbr_ymax;

--2
@extra-data

EXECUTE DBMS_MVIEW.REFRESH('DUTIES_MV')
set timing on
--a

select name, count
from duties
where count = (select max(count)
from duties);
--b

select name from forest_sensor
where sensor_id not in
(select sensor_id from sensor 
where last_charged > TO_DATE('10-AUG-2017 00:00:00', 'DD-MON-YYYY HH24:MI:SS')
and last_charged < TO_DATE('11-AUG-2017 00:00:00', 'DD-MON-YYYY HH24:MI:SS')
);

--c
--Q1_MV
select name, count
from duties_mv
where count = (select max(count)
from duties_mv);

--Q2_mv
drop MATERIALIZED view forest_sensor_mv;
create MATERIALIZED view forest_sensor_mv
	build immediate 
	refresh complete on demand
	as select forest_no, name, sensor_id
	from forest f join sensor s 
	on f.mbr_xmin < s.x and s.x < f.mbr_xmax and f.mbr_ymin < s.y and s.y < f.mbr_ymax;
	
select name from forest_sensor_mv
where sensor_id not in
(select sensor_id from sensor 
where last_charged > TO_DATE('10-AUG-2017 00:00:00', 'DD-MON-YYYY HH24:MI:SS')
and last_charged < TO_DATE('11-AUG-2017 00:00:00', 'DD-MON-YYYY HH24:MI:SS')
);
--d
set timing off

