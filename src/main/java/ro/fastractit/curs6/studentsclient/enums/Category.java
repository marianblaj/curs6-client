package ro.fastractit.curs6.studentsclient.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum Category {

    CATEGORY1,
    CATEGORY2,
    CATEGORY3,
    CATEGORY4;

    public static Optional<Category> of(String continentName) {
        return Stream.of(values())
                .filter(val -> val.name().equalsIgnoreCase(continentName))
                .findFirst();
    }

}
