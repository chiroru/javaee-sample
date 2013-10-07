package jp.ddo.chiroru.javaee.sample.integration.impl;

import jp.ddo.chiroru.javaee.sample.domain.Book;
import jp.ddo.chiroru.javaee.sample.integration.BookDao;

public class BookDaoImpl
        extends AbstractJpaDAO<Book>
        implements BookDao {

    public BookDaoImpl() {
        setClazz(Book.class);
    }
}
