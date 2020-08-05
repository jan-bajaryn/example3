package by.itransition.service;

import by.itransition.service.exception.WrongCountException;
import by.itransition.service.exception.WrongMistakesCountException;

public class ParamParser {
    public int parseCount(String param) throws WrongCountException {
        try {
            return Integer.parseInt(param);

        } catch (NumberFormatException e) {
            throw new WrongCountException();
        }
    }

    public double parseMistakes(String param) throws WrongMistakesCountException {
        try {
            return Double.parseDouble(param);
        }catch (NumberFormatException e){
            throw new WrongMistakesCountException();
        }
    }
}
