create or replace procedure pro_update_point
(customerID in customer.customer_id%type,
point in customer.total_points%type)
as
begin
	update customer
    set total_points = total_points + point
    where customer_id = customerID;
end;
/


create or replace function fun_get_promotion
(storeID in int, coffeeID in int)return int
is
promote_factor int;
promote_No int;
begin
select count(*) into promote_no
from haspromotion h  join promotefor f
on h.promotion_id = f.promotion_id
where f.coffee_id = coffeeId and h.store_id = storeID;
if promote_no = 0
	then promote_factor:= 1;
else
	promote_factor := 2*promote_no;
end if;
return (promote_factor);
end;
/




create or replace procedure pro_get_reward_point
(purchaseID in buyCoffee.purchase_ID%type,
coffeeID in buyCoffee.coffee_id%type,
customerID in customer.customer_id%type,
quantity in int,
totalreward out float)
as 
 level customer.memberlevel_id%type;
 factor memberLevel.booster_factor%type;
 reward coffee.reward_points%type;
 store int;
 promote int;
begin
    select memberlevel_id into level
    from customer
    where customer_id = customerID;
    select Booster_Factor into factor
    from memberlevel
    where memberlevel_id = level;
    select reward_points into reward
    from coffee
    where coffee_id = coffeeID;
    select store_id into store
    from purchase
    where purchase_id = purchaseID;
    promote := fun_get_promotion(store,coffeeID);
    totalreward := quantity * reward *factor*promote;
    return;
end;
/




create or replace procedure pro_get_redeem_point(
coffeeID in int,
quantity in int,
totalpoint out float
)
as
point float;
begin
	select redeem_points into point
    from coffee
    where coffee_id = coffeeID;
    totalpoint := quantity * point;
    return;
end;
/







create or replace trigger trig_update_point
after insert 
on buycoffee
for each row 
declare 
CID int;
point float;
begin
    select customer_id into CID
    from purchase 
    where purchase_id = :new.purchase_id;
    pro_get_reward_point(:new.purchase_id,CID, :new.coffee_id,:new.Purchase_Quantity, point);
    pro_update_point(CID, point);
end;
/



create or replace trigger trig_redeem_coffee
before insert
on buycoffee
for each row
declare
CID int;
customerPoint float;
pointNeeded float;
begin
	select customer_id into CID
	from purchase
	where purchase_id = :new.purchase_id;
	select total_points into customerPoint
	from customer
	where customer_id = CID;
	pro_get_redeem_point (:new.coffee_ID, :new.redeem_quantity, pointNeeded);
	if pointNeeded>customerPoint
	then
        Raise_Application_Error (-20001, 'The redeem point is too low.');
	else
		pointNeeded := -1*pointNeeded;
		pro_update_point(CID, pointNeeded);
        end if;
end;
/

create or replace trigger trig_coffee_available
before insert
on buycoffee
for each row
declare
SID int;
test int;
begin
	select store_id into SID
	from purchase
	where purchase_id = :new.purchase_id;
	select count(*) into test
	from offerCoffee
	where coffee_id = :new.coffee_id and store_id = SID;
	if test <1
    then 
		Raise_Application_Error (-20002, 'The store does not offer this coffee.');
    end if;
end;
/



create or replace trigger trig_add_promotion
before insert 
on hasPromotion
for each row 
declare
test int;
begin
	select count(*) into test
    from promotefor p  join offerCoffee o
	on o.coffee_id = p.coffee_id
    where p.promotion_id = :new.promotion_id
    and o.store_id = :new.store_id;
    if test<1
    then
		Raise_Application_Error (-20003, 'The store doesn not offer at least coffee in this promotion');
	end if;
end;
/




