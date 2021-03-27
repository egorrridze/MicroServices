package my.dataframecourse.serviceNew;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    String name;
    String lastName;
    String patronymic;

    @JsonCreator
    public Author(@JsonProperty("name") String name, @JsonProperty("lastName") String lastName, @JsonProperty("patronymic") String patronymic){
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
