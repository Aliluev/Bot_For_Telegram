package com.example.bot_for_telegram.ChatBox;

import com.example.bot_for_telegram.Data_Center.DataCache;
import com.example.bot_for_telegram.Data_Center.UserDataCache;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

//Класс для обработки первого сообщения

public class Asker implements InputMessage {

    private UserDataCache userDataCache;
    private ReplyChatBox messagesService;

    public Asker(UserDataCache userDataCache,ReplyChatBox messagesService){
        this.userDataCache = userDataCache;
        this.messagesService = messagesService;
    }

    @Override
    public SendMessage handle(Message message) {
        return processUsersInput(message);
    }

    @Override
    public BotState getStateName() {
        return BotState.START;
    }

    private SendMessage processUsersInput(Message inputMsg) {

        // !! было int !!!
        long userId = inputMsg.getFrom().getId();
        long chatId = inputMsg.getChatId();
        //Перевёл в Стринг
        String perem=String.valueOf(chatId);

        SendMessage replyToUser = messagesService.getReplyMessage(perem,"reply.askDestiny");
        userDataCache.setUsersCurrentBotState(perem,BotState.LVL1);

        return replyToUser;
    }



}
