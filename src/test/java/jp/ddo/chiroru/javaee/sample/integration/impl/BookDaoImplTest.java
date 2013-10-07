package jp.ddo.chiroru.javaee.sample.integration.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static jp.ddo.chiroru.testing.junit.matcher.BeanMatcher.*;

import java.util.List;

import jp.ddo.chiroru.javaee.sample.domain.Book;
import jp.ddo.chiroru.javaee.sample.integration.BookDao;
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
    @DataSetFixture("/jp/ddo/chiroru/javaee/sample/integration/impl/BookDaoImplTest_DataSet_00.xml")
    public void IDをキーに本の情報を検索できる()
            throws Exception {
        Book b = dao.findById(1);
        assertThat(b, is(bean(進撃の巨人_1巻.get())));
    }

    @Test
    @DataSetFixture("/jp/ddo/chiroru/javaee/sample/integration/impl/BookDaoImplTest_DataSet_01.xml")
    public void 登録されている全ての本の情報を検索できる()
            throws Exception {
        List<Book> actual = dao.findAll();
        assertThat(actual.get(0), is(bean(進撃の巨人_1巻.get())));
        assertThat(actual.get(1), is(bean(進撃の巨人_2巻.get())));
        assertThat(actual.get(2), is(bean(進撃の巨人_3巻.get())));
        assertThat(actual.get(3), is(bean(進撃の巨人_4巻.get())));
        assertThat(actual.get(4), is(bean(進撃の巨人_5巻.get())));
    }
    
    enum 本 {
        進撃の巨人_1巻(1L, "進撃の巨人", 1, "巨人と戦う。", "shingeki.png", 1),
        進撃の巨人_2巻(2L, "進撃の巨人", 2, "巨人と戦う。", "shingeki.png", 1),
        進撃の巨人_3巻(3L, "進撃の巨人", 3, "巨人と戦う。", "shingeki.png", 1),
        進撃の巨人_4巻(4L, "進撃の巨人", 4, "巨人と戦う。", "shingeki.png", 1),
        進撃の巨人_5巻(5L, "進撃の巨人", 5, "巨人と戦う。", "shingeki.png", 1);
        private Book b;
        private 本(Long id, String name, Integer volume, String description, String picture, Integer bookshelfId) {
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