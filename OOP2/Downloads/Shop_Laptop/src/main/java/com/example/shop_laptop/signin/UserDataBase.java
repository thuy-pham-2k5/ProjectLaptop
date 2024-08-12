package com.example.shop_laptop.signin;

import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public class UserDataBase {
    private final Map<String, String> userDatabase = new HashMap<>();

    public UserDataBase() {
        //Khởi tạo danh sách người dùng và mật khẩu
        userDatabase.put("admin", "password");
        userDatabase.put("thuypham", "pass1");
        userDatabase.put("hoangvu", "pass2");
        userDatabase.put("dungkieu", "pass3");
        userDatabase.put("phuonganh", "pass4");
        // Thêm các người dùng khác nếu cần
    }

    public boolean validateCredentials(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}
