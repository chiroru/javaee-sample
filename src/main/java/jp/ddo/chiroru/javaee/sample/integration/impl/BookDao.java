package jp.ddo.chiroru.javaee.sample.integration.impl;

import jp.ddo.chiroru.javaee.sample.domain.Book;

public interface BookDao {

    Book findById(Integer id);
}
