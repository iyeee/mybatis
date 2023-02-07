import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author iyeee
 * @Date 2023/2/7 20:43
 * @Version 1.0.1
 */
public class MybatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
            sqlSession=sqlSessionFactory.openSession();
            //执行sql语句
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            //没有异常提交
            sqlSession.commit();
        } catch (Exception e) {
            // 最好回滚事务
            if(sqlSession!=null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
