import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    /**
     * MyBatis的一级缓存:
     * MyBatis的一级缓存是SqlSession级别的，即通过同一个SQLSession查询的数据会被缓存
     * 再次使用同一个SQLSession查询同一条数据，会从缓存中获取
     */
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        Emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp1);
    }
    @Test
    public void testCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp empById = mapper1.getEmpById(1);
        System.out.println(empById);
        sqlSession1.close();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp empById1 = mapper2.getEmpById(1);
        System.out.println(empById1);
        sqlSession2.close();
    }
}
