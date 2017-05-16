select * from table where id=?
 
//queries used in MyCartDAOImpl
from MyCart where user_id=?
select sum(price) from MyCart where user_id=?
from MyCart where userID = ? and productName = ?
 
//queries used in UserDAOImpl
from Product where category_Id=?
from Product where name = ?
from Product where supplier_Id = ?
 
//queries used in UserDAOImpl
from Supplier
from Supplier where name = ?
 
//queries used in CategoryDAOImpl
from table
from table where name = ?
 
//queries used in UserDAOImpl
from User where id=? and password =?
from User
 
create table user
(
id varchar2(20) primary key,
name varchar2(20) not null,
password varchar2(20) not null,
contact varchar2(20) not null,
role varchar2(20) not null
)
 
create table category
(
id varchar2(20) primary key,
name varchar2(20) not null,
description varchar2(100) not null
)
 
 
create table supplier
(
id varchar2(20) primary key,
name varchar2(20) not null,
description varchar2(100) not null
)
 
create table product
(
id varchar2(20) primary key,
name varchar2(30) not null,
description varchar2(50) not null,
price number not null,
category_id varchar2(20) references TCategory(id) on delete cascade,
supplier_id varchar2(20) references TSupplier(id) on delete cascade,
)
 
create table MyCart
(
id int(20) NOT NULL primary key auto_increment,
user_id varchar2(20) references user(id),
product_name varchar2(30) references product(name),
price number,
status char default 'N',
date_added date default sysdate(),
quantity number default 1
)