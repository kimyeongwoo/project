create table tbl_member(
userid varchar2(50) not null primary key,
userpw varchar2(50) not null,
username varchar2(50) not null,
email1 varchar2(100) not null,
email2 varchar2(100) not null,
zipcode varchar2(50) not null,
addr varchar2(200) not null,
addr2 varchar2(200) not null,
tel1 varchar2(20) not null,
tel2 varchar2(20) not null,
tel3 varchar2(20) not null
);

insert into tbl_member values('kim', '123', '김영우', 'qnfdudn1604', 'naver.com', '140-773', '서울시 용산구', '이촌동', '010', '4118', '6700');