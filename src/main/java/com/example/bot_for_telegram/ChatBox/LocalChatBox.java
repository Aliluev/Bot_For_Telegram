package com.example.bot_for_telegram.ChatBox;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class LocalChatBox {
    private final Locale locale;
    private final MessageSource messageSource;

    public LocalChatBox(@Value("${localeTag}") String localeTag, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = Locale.forLanguageTag(localeTag);
    }


    public String getMessage(String message) {
        return messageSource.getMessage(message, null, locale);
    }

    public String getMessage(String message, Object... args) {
        return messageSource.getMessage(message, args, locale);
    }

}
