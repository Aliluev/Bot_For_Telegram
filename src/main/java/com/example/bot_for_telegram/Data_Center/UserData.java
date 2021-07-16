package com.example.bot_for_telegram.Data_Center;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserData {
    String name;
    String basketballName;
    String gender;
    boolean player;
    String basketballPlayer;
    String country;
    int age;
}
