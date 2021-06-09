package io.github.zhdanok.tourist.telegrambot;

import io.github.zhdanok.tourist.telegrambot.command.CommandContainer;
import io.github.zhdanok.tourist.telegrambot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("application.properties")
public class TouristBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    private final  CommandContainer commandContainer;

    public TouristBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageService(this));
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String commandIdentifier = update.getMessage().getText();
            commandContainer.retrieveCommand(commandIdentifier).execute(update);

        } else if (update.hasCallbackQuery() && update.getCallbackQuery().getMessage().hasText()) {
            String commandIdentifier = update.getCallbackQuery().getData().trim();
            commandContainer.retrieveCommand(commandIdentifier).execute(update);
        }
    }



    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
