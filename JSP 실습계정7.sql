 select * from p_product;
 
 insert into p_product (pcode, price, item, imagefilename, pname, event, brand, creationDate, eventMonth)
 VALUES ('8809256677835', 1500, '���ڷ�', '8809256677835.jpg', '����Ĩ','1+1', 'cu', sysdate, sysdate);
 
 SELECT pname, price, item, imageFileName, event, brand, eventMonth
 			 from p_product;
             
ALTER TABLE p_product MODIFY(price varchar2(20));

TRUNCATE TABLE p_product;

insert into p_product (pcode, price, item, imagefilename, pname, event, brand, creationDate, eventMonth)
VALUES ( '880417250050687', '1,800��','snack', '8801725000687.jpg','����)�����������Ͻ�63g', '2+1','CU', '20/11/17','20/11')