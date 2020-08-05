package by.itransition.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Person {
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String phone;

    public String toPrint() {
        return surname + " " + name + " " + patronymic + "; " + address + "; " + phone;
    }
}
