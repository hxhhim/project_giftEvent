select g.*, d.fileName from t_shopping_goods g, t_goods_detail_image d
where g.goods_id = d.goods_id
and d.filetype='main_image';

select * from t_goods_detail_image;

select g.*,d.fileName from t_shopping_goods g, t_goods_detail_image d
		    where g.goods_id=d.goods_id
		    and d.filetype='main_image'
		    and g.goods_title like '%'|| 'µö·¯´×' || '%'
		    order by g.goods_creDate desc;
            
            select goods_title from t_shopping_goods 
        where         
        goods_title like '%'|| 'µö·¯´×' || '%'
        order by goods_creDate desc;

select * from t_shopping_member;

select decode(count(*),1, 'true', 0, 'false')
	   from t_shopping_member
	   where member_id = 'lee';
       
       select ORDER_SEQ_NUM.nextval from dual;

        
