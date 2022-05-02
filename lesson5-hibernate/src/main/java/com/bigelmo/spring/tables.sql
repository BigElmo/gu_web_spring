create table customers (
    id bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table orders (
    id bigint not null auto_increment,
    price integer,
    customer_id bigint,
    product_id bigint,
    primary key (id)
);

create table products (
    id bigint not null auto_increment,
    name varchar(255),
    price integer,
    primary key (id)
);

alter table orders
    add constraint FKpxtb8awmi0dk6smoh2vp1litg
        foreign key (customer_id)
            references customers (id);

alter table orders
    add constraint FKkp5k52qtiygd8jkag4hayd0qg
        foreign key (product_id)
            references products (id);

insert into products (name, price)
values ('Phone', 2500);
insert into products (name, price)
values ('PC', 90000);
insert into products (name, price)
values ('TV', 30000);
insert into products (name, price)
values ('Monitor', 15000);
insert into products (name, price)
values ('Keyboard', 2000);

insert into customers (name)
values ('Admin');
insert into customers (name)
values ('Guest');

insert into orders (customer_id, product_id, price)
values (1,1,2500);
insert into orders (customer_id, product_id, price)
values (1,2,90000);
insert into orders (customer_id, product_id, price)
values (1,3,30000);
insert into orders (customer_id, product_id, price)
values (2,1,2500);
insert into orders (customer_id, product_id, price)
values (2,3,30000);
insert into orders (customer_id, product_id, price)
values (2,5,2000);
