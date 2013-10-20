package jp.ddo.chiroru.javaee.sample.integration.impl.mybatis;

import javax.inject.Inject;

import jp.ddo.chiroru.javaee.sample.domain.Bookshelf;

import org.apache.ibatis.session.SqlSession;

public class BookshelfDaoImpl {

    @Inject
    private SqlSession sqlSession;
    
    public Bookshelf findById(Long id) {
        return sqlSession.selectOne("jp.ddo.chiroru.javaee.sample.integration.impl.mybatis.BookshelfDaoImpl.findById", id);
    }
}
