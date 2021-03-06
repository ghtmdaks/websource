-- member 테이블 생성
create table member(
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	gender nvarchar2(2) not null,
	email varchar2(50) not null
);
insert into member values('ho', 'ho', '호승민', '남', 'ho@sm');

select * from member where userid = 'hong' and password = 'hong';

alter table member modify(gender nvarchar2(10));

select * from member;

-- 비밀번호 변경
update MEMBER set password='변경비밀번호'; -- 이렇게 하면 멤버테이블 모든 비밀번호가 변경되버려
update MEMBER set password='변경비밀번호' where userid='아이디' and password='현재비밀번호';