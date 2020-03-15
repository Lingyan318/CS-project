insert into coffee (coffee_seq.nextval, 'Latte', 'Latte', 4, 5, 2, 8);
insert into coffee (coffee_seq.nextval, 'Black coffee', 'Black coffee', 5, 4.5, 1, 5);
insert into coffee (coffee_seq.nextval, 'American coffee', 'American coffee', 6, 5, 3, 15);
insert into coffee (coffee_seq.nextval, 'Cappuccino', 'Cappuccino', 2, 4.5, 1, 5);

insert into store values(store_seq.nextval, 'CoffeeOne', '233 washington street pittsburgh PA 30034', 'express', 12326, 321312);
insert into store values(store_seq.nextval, 'CoffeeTwo', '318 honey street washington DC 20012' , 'express', 32432, 334244);
insert into store values(store_seq.nextval, 'CoffeeThree', '23 corona street new york NY 40023', 'express', 46547, 234546);


INSERT INTO MemberLevel values (memberlevel_seq.nextval, 'first level', 1.5);
INSERT INTO MemberLevel values (memberlevel_seq.nextval, 'second level', 2.0);
INSERT INTO MemberLevel values (memberlevel_seq.nextval, 'third level', 3.0);

insert into offerCoffee values(1,1);
insert into offerCoffee values(1,2);
insert into offerCoffee values(1,3);
insert into offerCoffee values(2,1);
insert into offerCoffee values(2,2);
insert into offerCoffee values(3,2);
insert into offerCoffee values(3,3);
insert into offerCoffee values(3,4);

INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johna', 'Smith', '1@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 2, 250.0, 'Johnb', 'Smith', '2@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 3, 250.0, 'Johnc', 'Smith', '3@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johnd', 'Smith', '4@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 2, 250.0, 'Johne', 'Smith', '5@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johnf', 'Smith', '6@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 3, 250.0, 'Johng', 'Smith', '7@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johnh', 'Smith', '8@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johni', 'Smith', '9@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johnj', 'Smith', '10@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 2, 250.0, 'Johnk', 'Smith', '11@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johnl', 'Smith', '12@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 3, 250.0, 'Johnm', 'Smith', '13@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 3, 250.0, 'Johnn', 'Smith', '14@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 2, 250.0, 'Johno', 'Smith', '15@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 2, 250.0, 'Johnp', 'Smith', '16@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 2, 250.0, 'Johnq', 'Smith', '17@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johnr', 'Smith', '18@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johns', 'Smith', '19@gmail.com');
INSERT INTO Customer values (customer_seq.nextval, 1, 250.0, 'Johnt', 'Smith', '20@gmail.com');


insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 1, 1,TO_DATE('2017/01/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 2, 2,TO_DATE('2017/01/13 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 2, 3,TO_DATE('2017/01/30 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 3, 2,TO_DATE('2017/01/20 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 5, 1,TO_DATE('2017/11/11 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 6, 2,TO_DATE('2017/02/11 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 7, 3,TO_DATE('2018/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 2, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 5, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 9, 1,TO_DATE('2017/09/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 11, 3,TO_DATE('2013/01/02 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 15, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 12, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 13, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 15, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 19, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 20, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 9, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 2, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 3, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 7, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 15, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 12, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 11, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 16, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 18, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 20, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 19, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 11, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 14, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 15, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 10, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 3, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 4, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 14, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 16, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 18, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 2, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 1, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 5, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 7, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 8, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 9, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 19, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 11, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 12, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 16, 1,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 17, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 18, 2,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into purchase(purchase_id, customer_id, store_id,purchase_time)
values (purchase_seq.nextval, 2, 3,TO_DATE('2017/01/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));



insert into promotion values(1,'promotion1',TO_DATE('2017/01/02 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2017/01/30 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into promotion values(2,'promotion2',TO_DATE('2017/01/02 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2017/01/30 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into promotion values(3,'promotion2',TO_DATE('2017/03/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2017/03/30 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into promotion values(4,'promotion4',TO_DATE('2017/04/01 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2017/04/30 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));



insert into promoteFor values(1,1);
insert into promoteFor values(2,2);
insert into promoteFor values(3,3);
insert into promoteFor values(4,4);

insert into hasPromotion values(1,1);
insert into hasPromotion values(2,1);
insert into hasPromotion values(3,2);
insert into hasPromotion values(2,2);
insert into haspromotion values(1,4);

insert into buyCoffee values(2,2,1,0);
insert into buycoffee values(1,1,3,0);

