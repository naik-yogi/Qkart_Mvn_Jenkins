package automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataGenerator {
    public static String getTimestampUsername() {
        return "user" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String getPassword() {
        return "Pass@123"; // Static password
    }
}
