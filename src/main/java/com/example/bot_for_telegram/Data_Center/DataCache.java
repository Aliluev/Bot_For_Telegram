package com.example.bot_for_telegram.Data_Center;

import com.example.bot_for_telegram.ChatBox.BotState;


//Всё заменил на String

public interface DataCache {
    void setUsersCurrentBotState(String userId, BotState botState);

    BotState getUsersCurrentBotState(String userId);

    UserData getUserProfileData(String userId);

    void saveUserProfileData(String userId, UserData userProfileData);
}
