
Drop table forest cascade constraints;
Drop table State cascade constraints;
Drop table Coverage cascade constraints;
Drop table Road cascade constraints;
Drop table Intersection cascade constraints;
Drop table Sensor cascade constraints;
Drop table Report cascade constraints;
Drop table Worker cascade constraints;

create table forest(
Forest_No varchar2(10),
Name varchar(30),
Area float,
Acid_Level float,
MBR_XMin float,
MBR_XMax float,
MBR_YMin float,
MBR_YMax float,
Constraint pk_forest primary key(Forest_No)
);



Create table State(
Name varchar(30),
Abbreviation varchar(2),
Area float,
Population int,
Constraint pk_Name primary key(Name) 
);


Create table Coverage(
Forest_No varchar2(10),
State varchar2(2),
Percentage float,
Area float,
constraint pk_forest_No primary key (Forest_No),
constraint fk_forest_No foreign key (Forest_No) references Forest(Forest_No)
);


Create table Road(
Road_No varchar2(10) not null,
Name varchar(30),
Length float,
constraint pk_Road_No primary key(Road_No)
);



Create table intersection(
Forest_No varchar2(10)not null,
Road_No varchar2(10)not null,
constraint fk1_forest_No foreign key(Forest_No) references Forest(Forest_No),
constraint fk_road_No foreign key(Road_No) references Road(Road_No)
);


Create table Sensor(
Sensor_Id int not null,
X float,
Y float,
Last_Charged date,
constraint pk_sensor_Id Primary key(Sensor_Id)
);


Create table Report(
Sensor_Id int not null,
Temperature float,
Report_Time date,
primary key(Sensor_Id),
constraint fk_Sensor_Id Foreign key(Sensor_Id) references Sensor(Sensor_Id)
);


Create table Worker(
SSN varchar2(9) not null,
Name varchar(30),
Age int,
Rank int,
Constraint pk_SSN primary key(SSN) 
);

Alter table State add unique(Abbreviation);
Alter table Worker add unique(Rank);

alter table Sensor add energy int;
ALTER TABLE Sensor ADD CONSTRAINT chk_energy CHECK (energy > =0);
alter table sensor add maintainer varchar2(9);
alter table Sensor modify maintainer default 'null';
ALTER TABLE Sensor ADD FOREIGN KEY (Maintainer) REFERENCES Worker(SSN);
