mybatis小技巧

### {} 和 ${}
1. 
   1. 底层使用PrepareStatement，先进性sql语句的编译，然后给sql语句的占位符问号？传值，避免sql注入
   2. 底层使用statement，先进行sql语句的拼接，然后再对语句进行编译，存在sql注入的风险
   3. 优先使用 #{} ，避免sql注入的风险
   4. 如果需要sql语句的关键词放到sql语句中，只能使用${}，因为#{}是以值的形式放到sql语句，'desc' 和 desc
2. 拼接表名    分表，提高效率，扫描的数据量更小   用select * from t_log_${date}
   1. t_log_20220901
   2. t_log_20220902
3. 批量删除
   1. 第一种 or  动态sql
   2. 第二种 in  delete from t_car where id in (${ids})    "5,6,7"

4. 模糊查询
   1. select * from t_car where  brand like '${brand}%'
   2.  where brand like concat(#{brand},'%')
   3. where brand like concat('${brand}','%');
   4.  where brand like ""#{brand}"%"
### 别名机制

### mapper属性
1. resource类路径下查找     url绝对路径，移植极差    class这个位置提供的是mapper接口的全限定接口名，必须带有包名的，会在同级目录下查找
2. resources中建目录 com/powernode/mybatis/mapper