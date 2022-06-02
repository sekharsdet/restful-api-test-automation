package petstore.builders;

import petstore.models.Category;
import petstore.models.Pet;
import petstore.models.Tag;

import java.util.ArrayList;
import java.util.List;

public class CreatePet {
    public static Pet createThePet() {
        Category category = Category.builder().id(1).name("Cats").build();
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("url");
        List<Tag> tags = createTags();
        return Pet.builder()
                .id(1)
                .name("snoopy")
                .category(category)
                .photoUrls(photoUrls)
                .tags(tags)
                .status("available")
                .build();
    }

    private static List<Tag> createTags() {
        Tag tag = Tag.builder().id(1).name("snoopy").build();
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        return tags;
    }
}
