package io.github.zhdanok.tourist.telegrambot.service;

import io.github.zhdanok.tourist.telegrambot.TouristBot;
import io.github.zhdanok.tourist.web.repository.CityRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

import static io.github.zhdanok.tourist.strings.FinalStrings.*;

@Service
public class MessageService {

    @Autowired
    TouristBot touristBot;

    @Autowired
    CityRepository cityRepository;

    private static final Logger log = Logger.getLogger(MessageService.class);

    public void sendStartMessage(Update update, ReplyKeyboardMarkup keyboardMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString())
                .enableHtml(true)
                .setText(START_MESSAGE)
                .setReplyMarkup(keyboardMarkup);
        try {
            touristBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.toString());
        }
    }

    public void sendInfoAboutCity(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString())
                .enableHtml(true)
                .setText(Optional.ofNullable(
                        cityRepository.getInfoByCity(update.getMessage().getText()))
                        .orElse(NOT_FOUND));
        try {
            touristBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.toString());
        }
    }

    public void sendAllCity(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString())
                .enableHtml(true)
                .setText(Optional.ofNullable(cityRepository.getAllCities())
                        .orElse(IS_EMPTY)
                        .toString());
        try {
            touristBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.toString());
        }
    }

    public void sendHelp(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString())
                .enableHtml(true)
                .setText(HELP);
        try {
            touristBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.toString());
        }
    }
}
