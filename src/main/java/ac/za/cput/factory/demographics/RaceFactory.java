package ac.za.cput.factory.demographics;

import ac.za.cput.domain.demographics.Race;
import ac.za.cput.util.uuid;

public class RaceFactory {
    public static Race getRace(String name)
    {
        return new Race.Builder().id(uuid.getUUID()).name(name).build();
    }
}
