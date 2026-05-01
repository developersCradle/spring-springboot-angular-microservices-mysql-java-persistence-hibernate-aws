package jsonparsing.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class BookPOJO {
    String title;
    boolean inPrint;
    LocalDate publishDate;
}
