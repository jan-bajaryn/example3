package by.itransition.entity;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

public enum SupportedLocales {

    BELARUS("be_BY", new Locale("by")),

    USA("en_US", new Locale("en_US")),

    RUS("ru_RU", new Locale("ru_RU"));

    private String inputLocale;
    private Locale outputLocale;


    SupportedLocales(String inputLocale, Locale outputLocale) {
        this.inputLocale = inputLocale;
        this.outputLocale = outputLocale;
    }

    public static Locale of(String inputLocale) {
        Optional<SupportedLocales> any = Arrays.stream(SupportedLocales.values())
                .filter(l -> l.inputLocale.equals(inputLocale))
                .findAny();
        return any.map(supportedLocales -> supportedLocales.outputLocale).orElse(null);
    }
}
