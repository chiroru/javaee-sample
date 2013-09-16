package jp.ddo.chiroru.javaee.sample.common.validation.validator;

import javax.validation.ValidatorContext;

public interface ValidatorContextAwareConstraintValidator {

    void setValidatorContext(ValidatorContext validatorContext);
}
