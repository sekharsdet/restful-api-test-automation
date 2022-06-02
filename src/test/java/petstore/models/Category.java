package petstore.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Category {
    private Integer id;
    private String name;
}
