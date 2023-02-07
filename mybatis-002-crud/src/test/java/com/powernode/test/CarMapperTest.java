package com.powernode.test;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author iyeee
 * @Date 2023/2/8 0:34
 * @Version 1.0.1
 */
public class CarMapperTest {
    @Test
    public void testNameSpace(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        // namespace.id!!!!
        List<Object> selectAll = sqlSession.selectList("sss.selectAll");
        selectAll.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        cars.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        // jdbc中的ReseltSet
        Object car= sqlSession.selectOne("selectById",6);
        System.out.println(car);
        sqlSession.close();

    }
    @Test
    public void testUpdateById(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        Car car=new Car(3L,"999","丰田",30.0,"1999-11-11","燃油车");
        int count = sqlSession.update("updateById",car);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count);

    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession=SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteById", 1);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count);
    }
    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession= SqlSessionUtil.openSession();
        Car car=new Car(null,"3333","byd2",30.0,"2020-11-11","新能");
        sqlSession.insert("insertCar",car);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testInsertCar(){
        SqlSession sqlSession= SqlSessionUtil.openSession();
        // 先用Map集合进行数据的封装
        // java语言中可以给sql语句的占位符传值
        // insert into t_car(id,car_no,brand,guide_price,produce_time,car_type) values(null,#{k1},#{k2},#{k3},#{k4},#{k5});
        // 一般map集合的k取名见名知意
        Map<String,Object> map=new HashMap<>();
        // map.put("k1","1111");
        // map.put("k2","byd");
        // map.put("k3","10.0");
        // map.put("k4","2020-11-11");
        // map.put("k5","电车");
        map.put("carNum","1111");
        map.put("brand","byd");
        map.put("guidePrice","10.0");
        map.put("produceTime","2020-11-11");
        map.put("carType","电车");
        // sqlID
        // 封装数据的对象
        int insert = sqlSession.insert("insertCar",map);
        sqlSession.commit();
        sqlSession.close();
    }
}
