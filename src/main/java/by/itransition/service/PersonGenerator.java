package by.itransition.service;

import by.itransition.entity.Person;
import by.itransition.entity.SupportedLocales;
import by.itransition.service.exception.UnsupportedCountException;
import by.itransition.service.exception.UnsupportedLocaleException;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonGenerator {

    public List<Person> generate(String locale, int count) throws UnsupportedLocaleException, UnsupportedCountException {
        Locale of = SupportedLocales.of(locale);
        check(count, of);
        Faker faker = new Faker(of);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // [0] - name, [1] - surname, [2] - patronymic
            String[] nameWithMiddle = faker.name().nameWithMiddle().split("\\s");
            Address addr = faker.address();
            String address = addr.zipCode() + ", " + addr.fullAddress();
            String phone = faker.phoneNumber().cellPhone();
            people.add(buildPerson(nameWithMiddle, phone, address));
        }
        return people;
    }

    private Person buildPerson(String[] nameWithMiddle, String phone, String address) {
        return Person.builder()
                .name(nameWithMiddle[0])
                .surname(nameWithMiddle[1])
                .patronymic(nameWithMiddle[2])
                .phone(phone)
                .address(address)
                .build();
    }

    private void check(int count, Locale of) throws UnsupportedLocaleException, UnsupportedCountException {
        if (of == null) {
            throw new UnsupportedLocaleException("Unsupported locale");
        }
        if (count < 0) {
            throw new UnsupportedCountException();
        }
    }
}
