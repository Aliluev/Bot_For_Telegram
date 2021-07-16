package com.example.bot_for_telegram.ChatBox;


import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;



@Service
public class ReplyChatBox {
    ReplyChatBox (){};
    private LocalChatBox localChatBox;

    public ReplyChatBox(LocalChatBox localChatBox) {
        this.localChatBox = localChatBox;
    }

    //       !!!!!  String chatId !!! String, а должен быть Long
    public SendMessage getReplyMessage(String chatId, String replyMessage) {
        SendMessage sendMessage = new SendMessage(chatId, localChatBox.getMessage(replyMessage));
        return sendMessage;
    }
    //       !!!!!  String chatId !!! String, а должен быть Long
    public SendMessage getReplyMessage(String chatId, String replyMessage, Object... args) {
        return new SendMessage(chatId, localChatBox.getMessage(replyMessage, args));
    }

}
