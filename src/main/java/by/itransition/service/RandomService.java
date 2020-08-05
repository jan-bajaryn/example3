package by.itransition.service;

import by.itransition.service.exception.IllegalPercentException;

import java.util.Random;

public class RandomService {
    private Random random = new Random();

    public boolean choose(int percentLuck) {
        if (percentLuck < 0 || percentLuck > 100) {
            throw new IllegalPercentException();
        }
        return random.nextInt(101) <= percentLuck;
    }

    public int randomPos(int maxInclusive) {
        return random.nextInt(maxInclusive + 1);
    }
}
