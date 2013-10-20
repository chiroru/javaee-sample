package jp.ddo.chiroru.javaee.sample.integration.impl.mybatis;

import static jp.ddo.chiroru.testing.junit.matcher.BeanMatcher.bean;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import jp.ddo.chiroru.javaee.sample.domain.Bookshelf;
import jp.ddo.chiroru.testing.integration.dao.mybatis.SqlSessionResource;
import jp.ddo.chiroru.testing.junit.dbunit.DBTestRunner;
import jp.ddo.chiroru.testing.junit.dbunit.DataSetFixture;
import jp.ddo.chiroru.testing.junit.external.H2DatabaseTCPServerManager;
import mockit.Deencapsulation;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DBTestRunner.class)
public class BookshelfDaoImplTest {

    @ClassRule
    public static H2DatabaseTCPServerManager manager = new H2DatabaseTCPServerManager();

    @Rule
    public SqlSessionResource sqlSeesionResource = new SqlSessionResource();
    
    private BookshelfDaoImpl dao;
    
    @Before
    public void setUp()
            throws Exception {
        dao = new BookshelfDaoImpl();
        Deencapsulation.setField(dao, sqlSeesionResource.getSqlSession(BookshelfDaoImplTest.class.getCanonicalName()));
    }

    @After
    public void tearDown()
            throws Exception {
        dao = null;
    }
    
    @Test
    @DataSetFixture("/jp/ddo/chiroru/javaee/sample/integration/impl/mybatis/BookshelfDaoImpl.xml")
    public void IDをキーに本の情報を検索できる()
            throws Exception {
        System.out.println(sqlSeesionResource.getSqlSession(BookshelfDaoImplTest.class.getCanonicalName()).getConnection().getAutoCommit());
        Bookshelf b = dao.findById(1L);
        assertThat(b, is(bean(本棚.コミック.get())));
    }

    enum 本棚 {
        コミック(1L, "コミック");
        private Bookshelf b;
        private 本棚(Long id, String name) {
            b = new Bookshelf();
            b.setId(id);
            b.setName(name);
        }
        public Bookshelf get() {
            return b;
        }
    }
}
