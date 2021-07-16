package com.example.bot_for_telegram.ChatBox;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BotStateContext {

    //                            BotState-Massage
        private Map<BotState, InputMessage> messageHandlers = new HashMap<>();
        //                        List Massage
        public BotStateContext(List<InputMessage> messageHandlers) {
            messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getStateName(), handler));
        }

        public SendMessage processInputMessage(BotState currentState, Message message) {
            InputMessage currentMessageHandler = findMessageHandler(currentState);
            return currentMessageHandler.handle(message);
        }

        private InputMessage findMessageHandler(BotState currentState) {
            if (isFillingProfileState(currentState)) {
                return messageHandlers.get(BotState.ZAPOLNENIE);
            }

            return messageHandlers.get(currentState);//получить message
        }

        private boolean isFillingProfileState(BotState currentState) {
            switch (currentState) {
                case START:
                case LVL1:
                case LVL2:
                case LVL3:
                case LVL4:
                case ZAPOLNENIE:
                case NOT_UNDESTAND:
                    return true;
                default:
                    return false;
            }
        }


    }
