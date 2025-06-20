#############################################################################
# guestbook만들기
#############################################################################

-- -----------------------------------------------------------------------------
# root 개정에서 실행
-- -----------------------------------------------------------------------------
-- 개정생성
create user 'guestbook'@'%' identified by 'guestbook';

-- 권한부여

grant all privileges on guestbook_db.* to 'guestbook'@'%';

-- guestbook_db 생성
create database guestbook_db
	default character set utf8mb4
    collate utf8mb4_general_ci
    default encryption='n'
    ;
    
show databases;
