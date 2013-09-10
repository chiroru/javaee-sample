/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ddo.chiroru.javaee.sample.service.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

    @AroundInvoke
    private Object intercepte(InvocationContext ic)
            throws Exception {
        System.out.println("common->" + ic.getTarget().toString() + "#" + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            System.out.println("common->" + ic.getTarget().toString() + "#" + ic.getMethod().getName());
        }
    }
}
