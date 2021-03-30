package com.lanjiu.im.storage.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class DBTools {

    private volatile static SqlSessionFactory factory = null;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 创建sqlSession:true->自动提交事务
    public static SqlSession getSession() {
        return factory.openSession(true);
    }
}
