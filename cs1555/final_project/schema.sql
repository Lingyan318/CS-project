drop table BuyCoffee cascade constraints;
drop table Store cascade constraints;
drop table Coffee cascade constraints;
drop table Promotion cascade constraints;
drop table HasPromotion cascade constraints;
drop table offerCoffee cascade constraints;
drop table PromoteFor cascade constraints;
drop table MemberLevel cascade constraints;
drop table Customer cascade constraints;
drop table Purchase cascade constraints;



create table Store(
	Store_ID int,
	Name varchar2(20),
	Address varchar2(100),
	Store_Type varchar2(20),
	GPS_Long float,
	GPS_Lat float,
	constraint store_PK primary key (Store_id)
);

create table Coffee(
	Coffee_ID int,
	Name varchar2(20),
	Description varchar2(20),
	Intensity int,
	Price float,
	Reward_Points float,
	Redeem_Points float,
	constraint Coffee_PK primary key (Coffee_ID)
);

create table Promotion(
	Promotion_ID int,
	Name varchar2(20),
	Start_Date date,
	End_Date date,
	constraint promotion_PK primary key(Promotion_ID)
);

create table OfferCoffee (
 Store_ID int,
 Coffee_ID int,
 constraint pk_offerCoffee primary key(Store_ID, Coffee_ID),
 constraint fk1_offerCoffee foreign key(Store_ID) references Store(Store_ID),
 constraint fk2_offerCoffee foreign key(Coffee_ID) references Coffee(Coffee_ID)
);

create table HasPromotion(
 Store_ID int,
 Promotion_ID int,
 constraint pk_hasPromotion primary key(Store_ID, Promotion_ID),
 constraint fk1_hasPromotion foreign key(Store_ID) references Store(Store_ID),
 constraint fk2_hasPromotion foreign key(Promotion_ID) references Promotion(Promotion_ID)
);

create table PromoteFor(
 Promotion_ID int,
 Coffee_ID int,
 constraint pk_promoteFor primary key(Promotion_ID, Coffee_ID),
 constraint fk1_promoteFor foreign key(Promotion_ID) references Promotion(Promotion_ID),
 constraint fk2_promoteFor foreign key(Coffee_ID) references Coffee(Coffee_ID)
);

create table MemberLevel (
	MemberLevel_ID	int,
	Name			varchar2(20),
	Booster_Factor	float,
	Constraint MemberLevel_pk primary key (MemberLevel_ID)
);

create table Customer (
	Customer_ID		int,
	First_Name		varchar2(20),
	Last_Name		varchar2(20),
	Email			varchar2(20) unique,
    MemberLevel_ID	int,
	Total_Points	float,
	Constraint Customer_pk primary key (Customer_ID),
	Constraint Customer_fk foreign key (MemberLevel_ID) references MemberLevel (MemberLevel_ID)
);

create table Purchase (
	Purchase_ID		int,
	Customer_ID		int,
	Store_ID		int,
	Purchase_Time	date,
	Constraint Purchase_pk primary key (Purchase_ID),
	Constraint Purchase_fk1 foreign key (Customer_ID) references Customer (Customer_ID),
	Constraint Purchase_fk2 foreign key (Store_ID) references Store (Store_ID)
);

create table BuyCoffee(
	Purchase_ID int,
	Coffee_ID int,
	Purchase_Quantity int,
	Redeem_Quantity int,
	constraint buyCoffee_PK primary key(Purchase_ID, Coffee_ID),
	constraint buyCoffee_FK1 foreign key (Purchase_ID) references purchase(Purchase_ID),
	constraint buyCoffee_FK2 foreign key (Coffee_ID) references Coffee(Coffee_ID)
);


drop sequence store_seq;
drop sequence coffee_seq;
drop sequence memberlevel_seq;
drop sequence purchase_seq;
drop sequence customer_seq;
drop sequence purchase_seq;
drop sequence promotion_seq;

CREATE SEQUENCE store_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE coffee_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;
 
CREATE SEQUENCE memberlevel_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;
 
CREATE SEQUENCE purchase_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE customer_seq
START WITH     1
INCREMENT BY   1
NOCACHE
NOCYCLE; 

CREATE SEQUENCE promotion_seq
START WITH 	1
INCREMENT BY 	1
NOCACHE
NOCYCLE;








