package by.itransition.service;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.*;

public class PersonGeneratorTest {
    @Test
    public void english() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en_US"), new RandomService());
        Faker faker = new Faker(new Locale("en_US"));
        System.out.println("faker.address() = " + faker.address().cityName());
        System.out.println("faker.name() = " + faker.name().firstName());
        System.out.println("faker.name() = " + faker.name().lastName());
        System.out.println("faker.superhero() = " + faker.name().fullName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.name().bloodGroup() = " + faker.name().bloodGroup());
        System.out.println("faker.name().nameWithMiddle() = " + faker.name().nameWithMiddle());
    }

    @Test
    public void rus() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("ru_RU"), new RandomService());
        Faker faker = new Faker(new Locale("ru_RU"),new RandomService());
        Name name = faker.name();


        System.out.println("name.prefix() = " + name.prefix());
        System.out.println("name.title() = " + name.title());
        System.out.println("name.nameWithMiddle() = " + name.nameWithMiddle());
        System.out.println("name.prefix() = " + name.prefix());
        System.out.println("name.suffix() = " + name.suffix());
        System.out.println("name.bloodGroup() = " + name.bloodGroup());
        System.out.println("name.fullName() = " + name.fullName());
        System.out.println("name.lastName() = " + name.lastName());
        System.out.println("name.name() = " + name.name());
        System.out.println("name.firstName() = " + name.firstName());
        System.out.println("name.username() = " + name.username());
        System.out.println(faker.address().cityPrefix());
        System.out.println(faker.address().streetSuffix());
        System.out.println(faker.address().latitude());
        System.out.println(faker.address().zipCode());
    }

    @Test
    public void bel() {
        Faker faker = new Faker(new Locale("by_BY"));

        System.out.println("faker.address() = " + faker.address().cityName());
        System.out.println("faker.name() = " + faker.name().firstName());
        System.out.println("faker.name() = " + faker.name().lastName());
        System.out.println("faker.superhero() = " + faker.name().fullName());
    }
}