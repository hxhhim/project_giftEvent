CREATE TABLE p_product(
    pcode varchar2(100) CONSTRAINT p_product_pcode_pk PRIMARY KEY,
    price VARCHAR2(50) CONSTRAINT p_product_price_NN NOT NULL,
    item VARCHAR2(50) CONSTRAINT p_product_item_NN NOT NULL,
    imageFileName VARCHAR2(100) CONSTRAINT p_product_imageFileName_NN NOT NULL,
    pname VARCHAR2(50) CONSTRAINT p_product_pname_NN NOT NULL,
    event VARCHAR2(20) CONSTRAINT p_product_event_NN NOT NULL,
    brand VARCHAR2(30)CONSTRAINT p_product_brand_NN NOT NULL,
    creationdate VARCHAR2(20)CONSTRAINT p_product_creationdate_NN NOT NULL,
    eventMonth VARCHAR2(20)CONSTRAINT p_product_eventmonth_NN NOT NULL
    );
       
    DESC p_product;
    
    CREATE TABLE likeList(
        id varchar2(50)CONSTRAINT likeList_id_NN NOT NULL ,
        pcode varchar2(100) ,
        CONSTRAINT likeList_pcode_FK FOREIGN KEY(pcode) REFERENCES p_product(pcode)
    );
    DESC likeList;
    
    CREATE TABLE p_member(
        id varchar2(50) CONSTRAINT p_member_id_NN NOT NULL,
        name VARCHAR2(50) CONSTRAINT p_member_name_NN NOT NULL,
        password varchar2(50) CONSTRAINT p_member_password_NN NOT NULL,
        email varchar2(100) CONSTRAINT p_member_email_NN NOT NULL,
        CONSTRAINT p_member_id_PK PRIMARY KEY(id)
    );
    
    desc p_member;
    
    CREATE TABLE articleboard(
        id varchar2(50) CONSTRAINT a_board_id_NN NOT NULL,
        title varchar2(50) CONSTRAINT a_board_title_NN NOT NULL,
        content varchar2(500) CONSTRAINT a_board_content_NN NOT NULL,
        writeDate DATE CONSTRAINT a_board_writeDate_NN NOT NULL,
        heart NUMBER ,
        articleNO NUMBER CONSTRAINT a_board_articleNO_NN NOT NULL,
        CONSTRAINT a_board_id_FK FOREIGN KEY(id) REFERENCES p_member(id)
    );
    
    
    drop table likeList;
    drop table articleboard;
    drop table p_member;
    drop table p_product;
    
    commit;
    
    CREATE SEQUENCE ANO_SEQ
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 1000
    NOCYCLE
    CACHE 10;
    
    commit;
