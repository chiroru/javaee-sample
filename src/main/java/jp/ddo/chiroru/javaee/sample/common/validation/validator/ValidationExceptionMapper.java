package jp.ddo.chiroru.javaee.sample.common.validation.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ValidationExceptionMapper
        implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {

        Response r = null;
        try {
        Set<ConstraintViolation<?>> vs = e.getConstraintViolations();
        for (ConstraintViolation<?> v : vs) {
            System.out.println(v.getMessage());
        }
        r = Response.status(200).entity("aaa").type(MediaType.APPLICATION_JSON).build();
        } catch (Exception ex) {
            System.out.println("--------------->" + ex.getMessage());
        }
        return r;
    }

}
