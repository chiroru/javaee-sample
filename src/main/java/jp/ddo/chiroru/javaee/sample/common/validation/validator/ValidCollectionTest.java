package jp.ddo.chiroru.javaee.sample.common.validation.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorContext;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidCollectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ValidCollectionTest.class);

    private static ValidatorFactory validatorFactory;

    @BeforeClass
    public static void createValidatorFactory() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
    }

    private Validator getValidator() {
        ValidatorContext validatorContext = validatorFactory.usingContext();
        validatorContext.constraintValidatorFactory(new ConstraintValidatorFactoryImpl(validatorContext));
        Validator validator = validatorContext.getValidator();
        return validator;
    }

    @Test
    public void beanConstrained() {
        Employee se = new Employee();
        se.setFirstName("Santiago");
        se.setLastName("Ennis");
        se.setEmailAddresses(new ArrayList<String> ());
        se.getEmailAddresses().add("segmail.com");
        Employee me = new Employee();
        me.setEmailAddresses(new ArrayList<String> ());
        me.getEmailAddresses().add("me@gmail.com");

        Team team = new Team();
        team.setMembers(new HashSet<Employee>());
        team.getMembers().add(se);
        team.getMembers().add(me);

        Validator validator = getValidator();

        Set<ConstraintViolation<Team>> violations = validator.validate(team);
        for(ConstraintViolation<Team> violation : violations) {
            logger.info(violation.getMessage());
        }
    }

    @Test
    public void beanNotConstrained() {
        ShoppingCart cart = new ShoppingCart();
        cart.setItems(new ArrayList<String> ());
        cart.getItems().add("JSR-303 Book");
        cart.getItems().add("");

        Validator validator = getValidator();

        Set<ConstraintViolation<ShoppingCart>> violations = validator.validate(cart, Default.class);
        for(ConstraintViolation<ShoppingCart> violation : violations) {
            logger.info(violation.getMessage());
        }
    }
}
