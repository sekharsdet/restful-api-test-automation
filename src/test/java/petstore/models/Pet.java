package petstore.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Pet {
    private Integer id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
}
