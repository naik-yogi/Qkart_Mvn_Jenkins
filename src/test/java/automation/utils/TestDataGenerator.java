package automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestDataGenerator {

    // Using ThreadLocal to ensure each test thread gets a unique username
    private static final ThreadLocal<String> username = ThreadLocal
            .withInitial(() -> "User" + UUID.randomUUID().toString().substring(0, 8));

    public static String getRandomUUIDUsername() {
        return username.get(); // Get the unique thread-safe username
    }

    public static String getPassword() {
        return "Pass@123"; // Static password
    }
}
