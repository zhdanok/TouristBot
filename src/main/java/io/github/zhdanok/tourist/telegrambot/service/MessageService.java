package io.github.zhdanok.tourist.telegrambot.service;

import io.github.zhdanok.tourist.telegrambot.TouristBot;
import io.github.zhdanok.tourist.web.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    TouristBot touristBot;

    @Autowired
    CityRepository cityRepository;

    public static final String START_MESSAGE = "<b>Добро пожаловать!</b> \n" +
            "Напиши мне какой город ты собираешься посетить. Можешь использовать русский либо английский язык";

    public static final String NOT_FOUND = "К сожалению данный город отсутсвует в нашей базе";

    public void sendStartMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            touristBot.execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendInfoAboutCity(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.enableHtml(true);
        String info = cityRepository.getInfoByCity(update.getMessage().getText());
        if (info == null) {
            info = NOT_FOUND;
        }
        sendMessage.setText(info);

        try {
            touristBot.execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendAllCity(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.enableHtml(true);
        List<String> cityList = cityRepository.getAllCities();

        sendMessage.setText(cityList.toString());

        try {
            touristBot.execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
