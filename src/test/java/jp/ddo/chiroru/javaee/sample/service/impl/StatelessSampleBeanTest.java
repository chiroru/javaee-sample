/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ddo.chiroru.javaee.sample.service.impl;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Stateless Session Bean の状態は「存在する」、「存在しない」の２つの状態のみ。
 * 生成：「存在する」→「存在しない」
 * 破棄：「存在する」←「存在しない」
 * 
 */
@Ignore
public class StatelessSampleBeanTest {

    private final static Logger L = LoggerFactory.getLogger(StatelessSampleBeanTest.class);

    private static Context context;
    private static EJBContainer container;

    @BeforeClass
    public static void setUpEnviroment()
            throws Exception {
        L.info("[テストの初期化処理] ============================== [開始]");
        container = EJBContainer.createEJBContainer();
        context = container.getContext();
        L.info("[テストの初期化処理] ============================== [終了]");
    }

    @AfterClass
    public static void tearDownEnvironment()
            throws Exception {
        L.info("[テストの終了処理] ================================ [開始]");
        container.close();
        L.info("[テストの終了処理] ================================ [終了]");
    }

    public StatelessSampleBean lookup()
            throws Exception {
        return (StatelessSampleBean) context.lookup("java:global/classes/StatelessSampleBean");
    }

    @Test
    public void testSayHello()
            throws Exception {
        StatelessSampleBean bean = lookup();
        assertThat(bean.sayHello(), is("Hello!"));
    }
}
