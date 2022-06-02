package petstore.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Inventory {
    private Integer approved;
    private Integer placed;
    private Integer delivered;
}
