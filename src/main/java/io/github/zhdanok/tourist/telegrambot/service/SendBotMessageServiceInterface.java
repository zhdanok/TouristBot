package io.github.zhdanok.tourist.telegrambot.service;


public interface SendBotMessageServiceInterface {

    void sendMessage(String chatId, String message);

    void deleteMessage(String chatId, Integer message_id);

    void sendPhoto(String chatId, String url);
}
