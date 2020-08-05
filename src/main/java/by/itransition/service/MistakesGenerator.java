package by.itransition.service;

import by.itransition.entity.Person;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class MistakesGenerator {
    private RandomService randomService = new RandomService();

    public void generateMistakes(List<String> people, double probability) {
        if (Double.compare(probability, 0) == 0) {
            return;
        }
        System.out.println("generate");
        int whole = (int) probability;
        int part = (int) (probability * 100 - whole * 100);

        for (int j = 0; j < people.size(); j++) {
            for (int i = 0; i < whole; i++) {
                people.set(j, makeMistake(people.get(j)));
            }
            if (part != 0 && randomService.choose(part)) {
                people.set(j, makeMistake(people.get(j)));
            }
        }
    }

    private String makeMistake(String person) {
        if (randomService.choose(33)) {
            return addCharacter(person);
        } else if (randomService.choose(33)) {
            return distractCharacter(person);
        } else {
            return swapCharacters(person);
        }
    }

    private String swapCharacters(String person) {
        int random = randomService.randomPos(person.length() - 1);
        char[] chars = person.toCharArray();
        if (randomService.choose(50)) {
            // right
            int secPos = random + 1 % chars.length-1;
            swap(chars, random, secPos);
        } else {
            //left
            int sec = random - 1;
            int secPos = sec == -1 ? chars.length - 1 : sec;
            swap(chars, random, secPos);
        }
        return new String(chars);
    }

    private void swap(char[] chars, int firstPos, int secPos) {
        char temp = chars[firstPos];
        chars[firstPos] = chars[secPos];
        chars[secPos] = temp;
    }

    private String distractCharacter(String person) {
        int random = randomService.randomPos(person.length() - 1);
        return person.substring(0, random) + person.substring(random + 1, person.length());
    }

    private String addCharacter(String person) {
        int random = randomService.randomPos(person.length() - 1);
        String insertion = RandomStringUtils.randomAlphanumeric(1);
        return person.substring(0, random) + insertion + person.substring(random);
    }
}
