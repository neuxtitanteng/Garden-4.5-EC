--Member Module--
create table member_type(
	type_id nvarchar(50) not null,
	type_name nvarchar(100) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(type_id)
);


create table member(
	account nvarchar(200) not null,
	password nvarchar(200) ,
	name nvarchar(50) not null,
	birthday date ,
	email nvarchar(200) ,
	phone nvarchar(50) ,
	mobile nvarchar(50) ,
    city_id nvarchar(50) ,
    zipcode nvarchar(50),
    address nvarchar(500),

	is_open nvarchar(1) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(account)
);

create table member_type_mapping(
	account nvarchar(200) not null,
	type_id nvarchar(50) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(account,type_id)
);

--Exchange Product Module--
create table ex_product_category(
	category_id nvarchar(50) not null,
	category_name nvarchar(100) not null,
	description nvarchar(500),
	parent_id nvarchar(50) not null,
    is_open nvarchar(1) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(category_id)
);


create table ex_product_category_pile(
	category_id nvarchar(50) not null,
	sub_category_id nvarchar(50) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(category_id,sub_category_id)
);

create table ex_product(
	product_id nvarchar(50) not null,
	product_name nvarchar(200) not null,
	picture int not null,
	stock_status nvarchar(1) not null, --NORMAL / OUT_OF_STOCK--
    stock int not null,
    stock_limit_percent int ,
    description nvarchar(200) not null,
    introduction int not null,

    start_time datetime not null,
    end_time datetime not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(product_id)
);

create table ex_product_point_category(
    category_id nvarchar(50) not null, --DEFAULT / ADD_COST / DISCOUNT--
    category_name nvarchar(100) not null,
    orders int ,

    create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(category_id)
);

create table ex_product_point(
    point_id nvarchar(50) not null,
    category_id nvarchar(50) not null,
	product_id nvarchar(50) not null,

	point int not null,
	extra_cost int ,

    start_time datetime not null,
    end_time datetime not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(point_id)
);

--Shopping Module--

create table ex_product_favorite(
    product_id nvarchar(50) not null,
    account nvarchar(200) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(product_id,account)
);

create table ex_product_shopping_car(
    product_id nvarchar(50) not null,
    account nvarchar(200) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(product_id,account)
);

create table ex_product_order(
    order_id nvarchar(50) not null,
    account nvarchar(200) not null,
    status nvarchar(1) not null, --PENDING_PAYMENT / FINISHED / CANCELED--
    payment_type nvarchar(1) not null,
    point int not null,
    cost int not null,
    submit_time datetime not null,
    order_date datetime not null,
    order_year int not null,
    order_quarter int not null,
    order_month int not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(order_id)
);

create table ex_product_order_detail(
    order_id nvarchar(50) not null,
    product_id nvarchar(50) not null,
    product_name nvarchar(200) not null,

    point_category_name nvarchar(50) not null,
    quantity int not null,
    point int not null,
    cost int not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(order_id,product_id)
);

--MGM Module--
create table mgm_active(
	active_id nvarchar(50) not null,
	active_name nvarchar(100) not null,
    start_time datetime not null,
    end_time datetime not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(active_id)
);

create table mgm_active_promo_code(
	account nvarchar(200) not null,
	active_id nvarchar(50) not null,
    promo_code nvarchar(100) not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(account,active_id)
);

create table mgm_active_rec_type(
	active_id nvarchar(50) not null,
	type_id nvarchar(50) not null,
	type_name nvarchar(100) not null,
	limit_amount int not null,
	current_amount int not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(type_id,active_id)
);

create table mgm_active_rec(
    rec_id int not null,--Increment--
	active_id nvarchar(50) not null,
	type_id nvarchar(50) not null,
	promo_code nvarchar(100) not null,
	rec_account nvarchar(200) not null,
	amount int not null,
	point float not null,

    data_year int not null,
    data_quarter int not null,
    data_month int not null,
    data_date int not null,

	create_by nvarchar(100),
    create_time datetime,
    update_by nvarchar(100),
    update_time datetime,

	primary key(type_id,active_id)
);