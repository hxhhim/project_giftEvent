drop table member_t;

CREATE TABLE MEMBER_T (
ID VARCHAR2(20) PRIMARY KEY,
NAME VARCHAR2(30) NOT NULL,
PASSWORD VARCHAR2(20) NOT NULL,
EMAIL VARCHAR2(50),
NIKNAME VARCHAR2(60)
);

commit;

INSERT INTO MEMBER_T VALUES ('hong', 'ȫ�浿', 'hong1234', 'hong@test.com'); 
INSERT INTO MEMBER_T VALUES ('kim', '������', 'kim1234', 'kim@test.com');

select * from member_t
