package jsonparsing.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class DayPOJO {
    LocalDate date;
    String name;
}
