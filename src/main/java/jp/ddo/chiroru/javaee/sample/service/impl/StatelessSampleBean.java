/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ddo.chiroru.javaee.sample.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import jp.ddo.chiroru.javaee.sample.service.util.LoggingInterceptor;

@Stateless
public class StatelessSampleBean {

    @Interceptors(LoggingInterceptor.class) // Classに対して指定すると全メソッドに対して適応される。また、@ExcludeClassInterceptorsで注釈しインターセプタの対象から外すことも可能。
    public String sayHello() {
        return "Hello!";
    }

    @PostConstruct
    private void create() {
        System.out.println("生成処理が完了しました.");
    }

    @PreDestroy
    private void desctroy() {
        System.out.println("破棄処理を開始します");
    }

    @AroundInvoke
    private Object intercepte(InvocationContext ic)
            throws Exception {
        System.out.println(ic.getTarget().toString() + "#" + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            System.out.println(ic.getTarget().toString() + "#" + ic.getMethod().getName());
        }
    }
}
