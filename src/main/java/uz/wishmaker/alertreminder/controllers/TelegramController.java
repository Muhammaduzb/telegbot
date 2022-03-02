package uz.wishmaker.alertreminder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
@RestController
public class TelegramController extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "alertreminders_bot";
    }

    @Override
    public String getBotToken() {
        return "5252236047:AAEfXK-q8WBPtsFSY4YGkOT0bSfSV-BZLek";
    }

    @Override
    public void onUpdateReceived(Update update) {
//        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        Message message = null;
        try {
            message = update.getMessage();
            sendMessage.setChatId(message.getChatId().toString());
        } catch (NullPointerException e) {
            System.out.print("Caught NullPointerException");
        }
//        sendMessage.setChatId(message.getChatId().toString());
        System.out.println(message);
        System.out.println("teksti : " + message.getText());
        System.out.println("userni idisi : " + message.getChatId());
                if (message.hasText()) {
                    if (message.getText().equals("/start")) {
                        sendMessage.setChatId(message.getChatId().toString());
                        sendMessage.setText("You have started to our bot");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }
    }
}