--a
select name from forest where acid_Level< 0.85 and acid_level>0.65;

--b
select name from (forest f join coverage c on f.forest_No = c.forest_No) where state like 'PA';

--c
select c.state, s.area, sum(c.area) as area 
from coverage c join state s on c.state = s.abbreviation
group by c.state, s.area
having sum(c.area)/s.area>0.3;

--d
select * from sensor where maintainer is null;

--e
select s.sensor_id, w.ssn, w.name
from sensor s left join worker w on s.maintainer = w.ssn;

--f
select c.state as state1, c1.state as state2
from coverage c join coverage c1 on c.forest_no = c1.forest_no
where c.state != c1.state;

--g
select state, sum(area) as sum from coverage group by state having sum(area) >(select sum(area) from coverage where state like 'MD' group by state);