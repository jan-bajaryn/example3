package by.itransition.controller;

import by.itransition.entity.Person;
import by.itransition.service.MistakesGenerator;
import by.itransition.service.ParamParser;
import by.itransition.service.PersonGenerator;
import by.itransition.service.exception.UnsupportedCountException;
import by.itransition.service.exception.UnsupportedLocaleException;
import by.itransition.service.exception.WrongCountException;
import by.itransition.service.exception.WrongMistakesCountException;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MistakesGenerator mistakesGenerator = new MistakesGenerator();
        PersonGenerator personGenerator = new PersonGenerator();
        ParamParser paramParser = new ParamParser();

        try {
            List<Person> people = personGenerator.generate(args[0], paramParser.parseCount(args[1]));

            List<String> collect = people.stream()
                    .map(Person::toPrint)
                    .collect(Collectors.toList());

            mistakesGenerator.generateMistakes(collect, paramParser.parseMistakes(args.length == 2 ? "0" : args[2]));

            collect.forEach(System.out::println);
        } catch (WrongCountException e) {
            System.out.println("Count is wrong");
        } catch (WrongMistakesCountException e) {
            System.out.println("Wrong count of mistakes");
        } catch (UnsupportedLocaleException e) {
            System.out.println("Unsupported locale");
        } catch (UnsupportedCountException e) {
            System.out.println("Count can't be less than 0");
        }
    }
}
