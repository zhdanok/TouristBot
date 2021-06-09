package io.github.zhdanok.tourist.telegrambot.command;

import io.github.zhdanok.tourist.telegrambot.command.Command;
import io.github.zhdanok.tourist.telegrambot.service.SendBotMessageServiceInterface;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartComm implements Command {

    private final SendBotMessageServiceInterface sendBotMessageServiceI;
    public final static String START_MESSAGE = "<b>Добро пожаловать!</b> \nНапиши мне какой город ты собраешься " +
            "посетить. Можешь использовать русский либо английский язык";

    public StartComm(SendBotMessageServiceInterface sendBotMessageServiceI) {
        this.sendBotMessageServiceI = sendBotMessageServiceI;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageServiceI.sendMessage(chatId, START_MESSAGE);

    }
}
