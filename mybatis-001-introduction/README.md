+ resources目录
    资源文件，配置文件
    直接放到resources目录下的资源，等同于放到了类的路径下

+ <packaging>jar</packaging>
    + mybatis依赖
    + mysql驱动
    + 编写mybatis核心配置文件,mybatis-config.xml
    + 编写XxxMapper.xml
    + mybatis-config.xml中指定XxxMapper.xml文件路径
    + 编写mybatis程序
      + SqlSession专门用来执行sql语句，java程序和数据库之间的一次会话
      + 需要先获取SqlSessionFactory
      + SqlSessionBuilder对的build方法，获取一个SqlSessionFactory对象

+ mybatis核心对象
  + SqlSessionBuilder
  + SqlSessionFactory
  + SqlSession

+ 从 XML 中构建 SqlSessionFactory

+ mybatis有两个主要配置文件
  + mybatis-config.xml 核心配置文件，连接数据库信息等
  + XxxMapper.xml 编写sql的配置文件  (一般一个表一个)
    + t_user表，一般对应一个UserMapper.xml
    + t_student表，一般对应StudentMapper.xml