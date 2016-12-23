--���� ���̺�
create table product(
product_id number primary key,
product_name varchar2(50),
price number default 0,
description varchar2(500),
picture_url varchar2(500)
);

--����
--product_id number primary		key ��ǰ�ڵ�
--product_name varchar2(50)		��ǰ �̸�
--price number default 0		���� - �⺻�� 0, � ���� ���ö� �װ�����
--description varchar2(500)		����
--picture_url varchar2(500)		�̹��� �ּ�


insert into product values (1,'����',1500,'���� ���Ե� �������� �Ƿ�ȸ���� �����ϴ�. ��Ÿ�� C�� ǳ���մϴ�.','lemon.jpg');
insert into product values (2,'������',2000,'��Ÿ�� C�� ǳ���մϴ�. ������ �ֽ��� ���ø� �����ϴ�.','orange.jpg');
insert into product values (3,'Ű��',3000,'��Ÿ�� C�� �ſ� ǳ���մϴ�. ���̾�Ʈ�� �̿뿡 �����ϴ�.','kiwi.jpg');
insert into product values (4,'����',5000,'��������� �ٷ� �����ϰ� �־� �׻�ȭ �ۿ��� �մϴ�.','grape.jpg');
insert into product values (5,'����',8000,'��Ÿ�� C�� �ö󺸳��̵带 �ٷ� �����ϰ� �ֽ��ϴ�.','strawberry.jpg');
insert into product values (6,'��',7000,'�ó��Ǹ��� �����ϰ� �־� ���� ���濡 ���ٰ� �մϴ�.','tangerine.jpg');



--��ٱ��� ���̺�
create table cart(
cart_id number not null primary key,
userid varchar2(50) not null,
product_id number not null,
amount number default 0
);
--userid�� ȸ�����̺�(tb1_member)���� �����ðŰ�
--product_id�� ��ǰ���̺�(product)���� �����ðŴ�

--cart sequence ����
create sequence seq_cart
start with 10
increment by 1;





--foreign key ����
alter table cart add constraint cart_userid_fk
foreign key(userid) references tb1_member(userid);
alter table cart add constraint cart_productid_fk
foreign key(product_id) references product(product_id);




--kim�̶�� ����� 1�� ��ǰ�� 3���� ��ٱ��Ͽ� ����
insert into cart(cart_id, userid, product_id, amount) values(1, 'kim', 1, 3);

--���������ʴ� ��ǰ�ڵ�
insert into cart(cart_id, userid, product_id, amount) values(2, 'kim', 100, 3);
--���� �������� �θ�Ű�� ���ٰ� �������. �ֳ�? (product ���̺�)�� 100�� ���� ��ǰ�ڵ尡 �����ϱ�^^ foreign key ȿ����.
--���� alter table cart drop constraint cart_productid_fk; ��ɾ �Ἥ �ܷ�Ű�� ����� �����ϴ�
--��ٱ��� �κп��� ������ �ܷ�Ű�� ������ϴ°� ����.





--���̵�, �̸�, ��ǰ��, �ܰ�, �ݾ�(=�ܰ� x ����) �̷��� �������� ������? join�� ���
select c.userid, username, product_name, amount, price, (price * amount) money from tb1_member m, cart c, product p where m.userid=c.userid and c.product_id=p.product_id;










