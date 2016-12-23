create table tb1_member(
userid varchar2(50) not null primary key,
userpw varchar2(50) not null,
username varchar2(50) not null,
email varchar2(100),
regdate date default sysdate,
updatedate date default sysdate
);