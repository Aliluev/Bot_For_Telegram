package com.example.bot_for_telegram.ChatBox;

import com.example.bot_for_telegram.Data_Center.UserData;
import com.example.bot_for_telegram.Data_Center.UserDataCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
public class Chat_interface {
    private BotStateContext botStateContext;
    private UserDataCache userDataCache;
    public Chat_interface(){};
    public Chat_interface(BotStateContext botStateContext, UserDataCache userDataCache) {
        this.botStateContext = botStateContext;
        this.userDataCache = userDataCache;
    }

    public SendMessage handleUpdate(Update update) {
        SendMessage replyMessage = null;

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            log.info("New message from User:{}, chatId: {},  with text: {}",
                    message.getFrom().getUserName(), message.getChatId(), message.getText());
            replyMessage = handleInputMessage(message);
        }

        return replyMessage;
    }

    private SendMessage handleInputMessage(Message message) {
        String inputMsg = message.getText();
        long userId = message.getFrom().getId();
        //Перевожу в String
        String perem=String.valueOf(userId);
        BotState botState;
        SendMessage replyMessage;

        switch (inputMsg) {
            case "/start":
                botState = BotState.START;
                break;
                /*
            case "LVL1":
                botState = BotState.LVL1;
                break;
            case "LVL2":
                botState = BotState.SHOW_HELP_MENU;
                break;
                 */
            default:

                botState = userDataCache.getUsersCurrentBotState(perem);
                break;
        }

        userDataCache.setUsersCurrentBotState(perem, botState);

        replyMessage = botStateContext.processInputMessage(botState, message);

        return replyMessage;
    }


}
