create table cust_account(
    accountNO varchar2(20) primary key,
    custName varchar2(50),
    balance number(20,4)
    );
    
    insert into cust_account(accountNo, custName, balance)
    values('70-490-930','È«±æµ¿','10000000');
    
    insert into cust_account(accountNO, custNAme,balance)
    values('70-490-911','±èÀ¯½Å',10000000);
    
    update cust_account set balance=10000000 where accountno='70-490-911';
    update cust_account set balance=10000000 where accountno='70-490-930';
    
    
    
    commit;
    
    select * from cust_account;