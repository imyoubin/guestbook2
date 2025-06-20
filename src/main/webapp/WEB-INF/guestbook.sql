#############################################################################
# guestbook 만들기
#############################################################################

-- -----------------------------------------------------------------------------
-- guestbook_db 데이터베이스 사용
-- -----------------------------------------------------------------------------

use guestbook_db;

show databases;

show tables;

-- 테이블 생성
create table guestbook (
guest_id 				int primary key auto_increment,
name 					varchar(80) not null,
password 				varchar(20) not null,
content 				text not null,
reg_date datetime default current_timestamp
);



-- 방명록 데이터 삽입
insert into guestbook 
values ('정우성', '1234', '안녕하세요. 정우성입니다.');

insert into guestbook
values ('이효리', 'abcd', '반갑습니다. 이효리예요.');

insert into guestbook
values ('강호동', '0000', '힘이 납니다! 강호동입니다.');

select *
from guestbook
;
-- 방명록 수정
update guestbook
set name = '서장훈'
where guest_id = 4;

-- 방명록 삭제
delete from guestbook
where guest_id = 3;

-- 방명록 목록 조회
select 	guest_id,
		 name, 
		 password,
		 content,
		 reg_date
from guestbook
order by guest_id desc;