package io.github.zhdanok.tourist.strings;

import java.util.Arrays;
import java.util.List;

public class FinalStrings {

    public static final String START_MESSAGE = "<b>Добро пожаловать!</b> \n" +
            "Напиши мне какой город ты собираешься посетить. Можешь использовать " +
            "русский либо английский язык";

    public static final String NOT_FOUND = "К сожалению данный город отсутсвует в нашей базе";

    public static final List<String> IS_EMPTY = Arrays.asList("Наша база пока пуста. Скоро мы это исправим");

    public static final String HELP = "Для получения информации о городе отправьте его <b>название</b> на русском " +
            "или английском языке. \nДля получения списка всех городов, имеющихся в базе - нажмите кнопку " +
            "<b>'Список городов'</b> ";
}
