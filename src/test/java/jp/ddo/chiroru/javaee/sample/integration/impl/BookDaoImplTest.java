package jp.ddo.chiroru.javaee.sample.integration.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static jp.ddo.chiroru.testing.junit.matcher.BeanMatcher.*;
import jp.ddo.chiroru.javaee.sample.domain.Book;
import jp.ddo.chiroru.testing.junit.dbunit.DBTestRunner;
import jp.ddo.chiroru.testing.junit.dbunit.DataSetFixture;
import jp.ddo.chiroru.testing.junit.external.H2DatabaseTCPServerManager;
import jp.ddo.chiroru.testing.junit.jpa.EntityManagerResource;
import mockit.Deencapsulation;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static jp.ddo.chiroru.javaee.sample.integration.impl.BookDaoImplTest.本.*;

@RunWith(DBTestRunner.class)
@DataSetFixture("/jp/ddo/chiroru/javaee/sample/integration/impl/BookDaoImplTest_DataSet.xml")
public class BookDaoImplTest {

    private final static String PERSISTENCE_UNIT_NAME = "UT";

    @ClassRule
    public static H2DatabaseTCPServerManager manager = new H2DatabaseTCPServerManager();

    @Rule
    public EntityManagerResource emr = new EntityManagerResource(PERSISTENCE_UNIT_NAME);

    private BookDao dao;

    @Before
    public void setUp()
            throws Exception {
        dao = new BookDaoImpl();
        Deencapsulation.setField(dao, emr.getEntityManager());
    }

    @Test
    public void test()
            throws Exception {
        Book b = dao.findById(1);
        assertThat(b, is(bean(テスト本.get())));
    }

    enum 本 {
        テスト本(1, "進撃の巨人", 1, "巨人と戦う。", "shingeki.png", 1);
        private Book b;
        private 本(Integer id, String name, Integer volume, String description, String picture, Integer bookshelfId) {
            b = new Book();
            b.setId(id);
            b.setName(name);
            b.setVolume(volume);
            b.setDescription(description);
            b.setPicture(picture);
            b.setBookshelfId(bookshelfId);
        }
        
        public Book get() {
            return b;
        }
    }
}