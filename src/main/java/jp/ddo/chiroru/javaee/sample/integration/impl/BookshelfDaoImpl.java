package jp.ddo.chiroru.javaee.sample.integration.impl;

import jp.ddo.chiroru.javaee.sample.domain.Bookshelf;
import jp.ddo.chiroru.javaee.sample.integration.BookshelfDao;

public class BookshelfDaoImpl
        extends AbstractJpaDAO<Bookshelf>
        implements BookshelfDao {

    public BookshelfDaoImpl() {
        setClazz(Bookshelf.class);
    }
}
