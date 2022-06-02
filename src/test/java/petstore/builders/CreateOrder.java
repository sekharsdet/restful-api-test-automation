package petstore.builders;

import petstore.models.Order;

public class CreateOrder {
    public static Order createTheOrder()
    {
        return Order.builder()
                .id(1)
                .petId(1)
                .quantity(5)
                .shipDate("Thu Jun 02 2022 14:04:58 GMT+0200 (Central European Summer Time)")
                .status("approved")
                .complete(false)
                .build();
    }
}
