package com.example.bot_for_telegram.Data_Center;

import com.example.bot_for_telegram.ChatBox.BotState;

public interface DataCache {
    void setUsersCurrentBotState(int userId, BotState botState);

    BotState getUsersCurrentBotState(int userId);

    UserData getUserProfileData(int userId);

    void saveUserProfileData(int userId, UserData userProfileData);
}
