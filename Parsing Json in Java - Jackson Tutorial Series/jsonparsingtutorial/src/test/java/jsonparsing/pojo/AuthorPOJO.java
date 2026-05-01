package jsonparsing.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class AuthorPOJO {
    private String authorName;
    private List<BookPOJO> books;
}
