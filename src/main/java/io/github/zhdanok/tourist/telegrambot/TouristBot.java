package io.github.zhdanok.tourist.telegrambot;

import io.github.zhdanok.tourist.telegrambot.keyboard.ReplyKeyboardSource;
import io.github.zhdanok.tourist.telegrambot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static io.github.zhdanok.tourist.strings.FinalStrings.START_MESSAGE;
import static io.github.zhdanok.tourist.telegrambot.keyboard.ReplyKeyboardSource.getInitialKeyboard;


@Component
@PropertySource("application.properties")
public class TouristBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    @Autowired
    private MessageService messageService;





    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case ("/start"):
                    messageService.sendStartMessage(update, getInitialKeyboard());
                    break;
                case ("Список городов"):
                    messageService.sendAllCity(update);
                    break;
                case ("Помощь"):
                    messageService.sendHelp(update);
                    break;
                default:
                    messageService.sendInfoAboutCity(update);

            }
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
