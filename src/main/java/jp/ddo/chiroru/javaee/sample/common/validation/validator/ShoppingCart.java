package jp.ddo.chiroru.javaee.sample.common.validation.validator;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class ShoppingCart {
    private List<String> items;

    @ValidCollection(elementType=String.class, constraints={NotBlank.class})
    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }
}
