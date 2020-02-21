--ling yan
--liy64

@hw7-db

--3
--a
drop procedure pro_update_last_read;
create or replace procedure pro_update_last_read(sensorID in int, read_date in date)
	begin 
	update Last_read set last_read = read_date where sensorID = sensor_id;
	end;
	/
	
--b
create or replace function fun_compute_percentage(
	forestNo in varchar(10),
	area_cover in float,)
	return perc float
	begin
	select area_cover / f.area into perc from forest f;
	if perc <= 1
	then
	return perc;
	else
	return 1;
	end if;
	end;
	/
--4
--a
    create or replace trigger tri_last_read
		after update
		on report
		for each row when (new.sensor_ID = old.sensor_id)
		begin
		execute pro_update_last_read;
		end;
		/
--b
    create or replace trigger tri_percentage
		after update
		on forest
		for each row 
		begin
		execute fun_compute_percentage;
		end;
		/
--c  
     
     create or replace trigger tri_emergency
		 before insert
		 on report
		 for each row when (new.temperature >100)
		 begin
		 insert into emergency value(new.sensor_id, new.report_time);
	     end;
		 /