package petstore.builders;

import petstore.models.Order;

public class CreateOrder {
    public static Order createTheOrder()
    {
        return Order.builder()
                .id(1)
                .petId(1)
                .quantity(5)
                .shipDate("2022-06-02T16:24:57.926+00:00")
                .status("approved")
                .complete(false)
                .build();
    }
}
