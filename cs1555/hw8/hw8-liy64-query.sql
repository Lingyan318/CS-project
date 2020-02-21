Ling Yan
liy64

@hw8-liy64-db.sql


--3
--a
set transaction read write;
set constraint all deferred;
insert into road values('5', 'century road', 200);
set transaction read write name ’test’; 
--b
update sensor set maintainer='000000000' where maintainer='121212121';
update sensor set maintainer='121212121' where maintainer='222222222';
update sensor set maintainer='222222222' where maintainer='000000000';
	
--c
insert into worker values('555555555', 'Paula', 22, 1);
update sensor set maintainer='555555555' where sensor_id=1;
Commit;



