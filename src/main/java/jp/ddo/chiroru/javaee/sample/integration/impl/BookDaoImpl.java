package jp.ddo.chiroru.javaee.sample.integration.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jp.ddo.chiroru.javaee.sample.domain.Book;

public class BookDaoImpl
        implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book findById(Integer id) {

        return em.find(Book.class, id);
    }

}
