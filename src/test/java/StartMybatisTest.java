import com.java.tiantian.mybatis.User;
import com.java.tiantian.mybatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 天天
 * @version 1.0
 * @date 2020/12/14 13:53
 */
public class StartMybatisTest {

    @Test
    public void   test01(){
        String path = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            //　读取ｍｙｂａｔｉｓ的核心配置文件
            inputStream = Resources.getResourceAsStream(path);

            // 创建sqlsession工厂构建者对象 把核心配置交给代理商托管 并构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 通过工厂 打开session
        SqlSession sqlSession = sqlSessionFactory.openSession();
            // 通过sqlsession 底层是用反射 拿到ｍａｐｐｅｒ字节码　获取对应的方法
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 查询所有的 用户信息
            List<User> users = mapper.queryFindAll();
            for (User user : users) {
                System.out.println(user);
            }
            // 通过id删除 用户
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
