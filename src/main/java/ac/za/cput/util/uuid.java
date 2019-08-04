package ac.za.cput.util;

import java.util.UUID;

public class uuid {
    public static String getUUID()
    {
        return UUID.randomUUID().toString();
    }
}
