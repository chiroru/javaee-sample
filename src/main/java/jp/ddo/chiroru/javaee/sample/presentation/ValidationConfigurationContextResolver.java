package jp.ddo.chiroru.javaee.sample.presentation;

import javax.validation.Validation;
import javax.validation.ValidatorContext;
import javax.validation.ValidatorFactory;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;

import jp.ddo.chiroru.javaee.sample.common.validation.validator.ConstraintValidatorFactoryImpl;

import org.glassfish.jersey.server.validation.ValidationConfig;

public class ValidationConfigurationContextResolver
        implements ContextResolver<ValidationConfig> {

    private ValidatorFactory validatorFactory;

    @Context
    private ResourceContext resourceContext;

    @Override
    public ValidationConfig getContext(Class<?> type) {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        ValidatorContext validatorContext = validatorFactory.usingContext();
        validatorContext.constraintValidatorFactory(new ConstraintValidatorFactoryImpl(validatorContext));
        ValidationConfig config = new ValidationConfig();
        config.setConstraintValidatorFactory(new ConstraintValidatorFactoryImpl(validatorContext));
        return config;
    }
}
