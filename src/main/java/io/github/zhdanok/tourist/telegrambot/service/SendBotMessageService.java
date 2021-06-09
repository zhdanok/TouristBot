package io.github.zhdanok.tourist.telegrambot.service;

import io.github.zhdanok.tourist.telegrambot.TouristBot;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageService implements SendBotMessageServiceInterface {

    private final TouristBot touristBot;

    @Autowired
    public SendBotMessageService(TouristBot touristBot) {
        this.touristBot = touristBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
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

    @Override
    public void deleteMessage(String chatId, Integer message_id) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(chatId);
        deleteMessage.setMessageId(message_id);
        try {
            touristBot.execute(deleteMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendPhoto(String chatId, String url) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(url);
        try {
            touristBot.execute(sendPhoto);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
