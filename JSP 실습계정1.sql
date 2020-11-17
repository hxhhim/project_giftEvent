INSERT into t_board(articleNO,  title, content, imageFileName, id) VALUES(16 ,'스프링실습','무슨에러인가?'	,null ,'hong');

SELECT nvl(max(articleNO),0) +1 from t_board;

select * from t_board;

CREATE TABLE MEMBER_T (
ID VARCHAR2(20) PRIMARY KEY,
NAME VARCHAR2(30) NOT NULL,
PASSWORD VARCHAR2(20) NOT NULL,
EMAIL VARCHAR2(50)
);
commit;

INSERT INTO MEMBER_T 
       (ID, NAME, PASSWORD, EMAIL)
VALUES ('hong', '홍길동', 'hong1234', 'hong@test.com'); 
INSERT INTO MEMBER_T 
       (ID, NAME, PASSWORD, EMAIL)
VALUES ('kim', '김유신', 'kim1234', 'kim@test.com');

COMMIT;

SELECT * FROM MEMBER_T WHERE ID = 'kim' AND PASSWORD = 'kim134';

select * from member_t;

SELECT * FROM MEMBER_T WHERE ID = 'kim';

INSERT INTO MEMBER_T (ID, NAME, PASSWORD, EMAIL)
		VALUES ('cha', '차두리', '1234', 'cha@test.com'); 
        
        commit;
        
CREATE TABLE t_imageFile(
    imageFileNO number(10) primary key,
    imageFileName varchar2(50),
    regDate date DEFAULT sysdate,
    articleNO number(10),
    CONSTRAINT FK_ARTICLENO FOREIGN KEY(articleNO)
    REFERENCES t_board(articleNO)ON DELETE CASCADE);
    
    
    
    
