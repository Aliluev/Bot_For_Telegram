package com.example.bot_for_telegram.Data_Center;

import com.example.bot_for_telegram.ChatBox.BotState;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDataCache implements DataCache{
    private Map<String, BotState> usersBotStates = new HashMap<>();
    private Map<String, UserData> usersProfileData = new HashMap<>();

    // Заменил на String
    @Override
    public void setUsersCurrentBotState(String userId, BotState botState) {
        usersBotStates.put(userId, botState);
    }


    @Override
    public BotState getUsersCurrentBotState(String userId) {
        BotState botState = usersBotStates.get(userId);
        if (botState == null) {
            botState = BotState.START;
        }

        return botState;
    }

    @Override
    public UserData getUserProfileData(String userId) {
        UserData userProfileData = usersProfileData.get(userId);
        if (userProfileData == null) {
            userProfileData = new UserData();
        }
        return userProfileData;
    }

    @Override
    public void saveUserProfileData(String userId, UserData userProfileData) {
        usersProfileData.put(userId, userProfileData);
    }
}
