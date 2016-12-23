--물건 테이블
create table product(
product_id number primary key,
product_name varchar2(50),
price number default 0,
description varchar2(500),
picture_url varchar2(500)
);

--설명
--product_id number primary		key 상품코드
--product_name varchar2(50)		상품 이름
--price number default 0		가격 - 기본값 0, 어떤 값이 들어올때 그값으로
--description varchar2(500)		설명
--picture_url varchar2(500)		이미지 주소


insert into product values (1,'레몬',1500,'레몬에 포함된 구연산은 피로회복에 좋습니다. 비타민 C도 풍부합니다.','lemon.jpg');
insert into product values (2,'오렌지',2000,'비타민 C가 풍부합니다. 생과일 주스로 마시면 좋습니다.','orange.jpg');
insert into product values (3,'키위',3000,'비타민 C가 매우 풍부합니다. 다이어트나 미용에 좋습니다.','kiwi.jpg');
insert into product values (4,'포도',5000,'폴리페놀을 다량 함유하고 있어 항산화 작용을 합니다.','grape.jpg');
insert into product values (5,'딸기',8000,'비타민 C나 플라보노이드를 다량 함유하고 있습니다.','strawberry.jpg');
insert into product values (6,'귤',7000,'시네피린을 함유하고 있어 감기 예방에 좋다고 합니다.','tangerine.jpg');



--장바구니 테이블
create table cart(
cart_id number not null primary key,
userid varchar2(50) not null,
product_id number not null,
amount number default 0
);
--userid는 회원테이블(tb1_member)에서 가져올거고
--product_id는 상품테이블(product)에서 가져올거다

--cart sequence 생성
create sequence seq_cart
start with 10
increment by 1;





--foreign key 설정
alter table cart add constraint cart_userid_fk
foreign key(userid) references tb1_member(userid);
alter table cart add constraint cart_productid_fk
foreign key(product_id) references product(product_id);




--kim이라는 사람이 1번 상품을 3개나 장바구니에 담음
insert into cart(cart_id, userid, product_id, amount) values(1, 'kim', 1, 3);

--존재하지않는 상품코드
insert into cart(cart_id, userid, product_id, amount) values(2, 'kim', 100, 3);
--윗줄 돌려보면 부모키가 없다고 에러뜬다. 왜냐? (product 테이블)에 100을 가진 상품코드가 없으니까^^ foreign key 효과다.
--만약 alter table cart drop constraint cart_productid_fk; 명령어를 써서 외래키를 지우면 가능하다
--장바구니 부분에선 무조건 외래키를 써줘야하는거 같다.





--아이디, 이름, 상품명, 단가, 금액(=단가 x 수량) 이렇게 내보내고 싶으면? join을 써라
select c.userid, username, product_name, amount, price, (price * amount) money from tb1_member m, cart c, product p where m.userid=c.userid and c.product_id=p.product_id;










