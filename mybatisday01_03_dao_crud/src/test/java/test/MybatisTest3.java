package test;

import com.neusoft.dao.IUserDao2;
import com.neusoft.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest3 {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao2 userDao;

    //在测试方法之前执行
    @Before
    public void init() throws IOException
    {
        // 1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建 SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用 工厂生产的 SqlSession对象
        sqlSession = factory.openSession();
        // 4. 使用SqlSession 创建Dao 接口 的代理对象
        userDao = sqlSession.getMapper(IUserDao2.class);
    }

    @After
    public void destroy() throws IOException
    {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(45);

            System.out.println(user);

    }















}
