package com.example.bot_for_telegram.ChatBox;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface InputMessage {
    SendMessage handle(Message message);

    BotState getStateName();
}
