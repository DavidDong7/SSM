package test;

import com.neusoft.dao.IEmpDao;
import com.neusoft.domain.Emp;
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

public class MybatisTest {

    private InputStream inputStream;
    private SqlSessionFactoryBuilder factoryBuilder;
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;
    private IEmpDao empDao;
    @Before
    public void init() throws IOException
    {

        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factoryBuilder = new SqlSessionFactoryBuilder();
        sessionFactory = factoryBuilder.build(inputStream);
        sqlSession = sessionFactory.openSession();
        empDao = sqlSession.getMapper(IEmpDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindAll(){
        List<Emp> emps = empDao.findAll();
        for (Emp emp:emps) {
            System.out.println(emp);
        }
    }

}
