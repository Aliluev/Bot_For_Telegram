package com.example.bot_for_telegram.Data_Center;

import com.example.bot_for_telegram.ChatBox.BotState;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDataCache implements DataCache{
    private Map<Integer, BotState> usersBotStates = new HashMap<>();
    private Map<Integer, UserData> usersProfileData = new HashMap<>();
    @Override
    public void setUsersCurrentBotState(int userId, BotState botState) {
        usersBotStates.put(userId, botState);
    }

    @Override
    public BotState getUsersCurrentBotState(int userId) {
        return null;
    }

    @Override
    public UserData getUserProfileData(int userId) {
        return null;
    }

    @Override
    public void saveUserProfileData(int userId, UserData userProfileData) {

    }
}
