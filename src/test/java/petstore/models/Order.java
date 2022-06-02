package petstore.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Order {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}
