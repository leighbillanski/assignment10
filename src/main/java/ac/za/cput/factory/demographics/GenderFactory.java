package ac.za.cput.factory.demographics;

import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.util.uuid;

public class GenderFactory {
    public static Gender getGender(String name)
    {
        return new Gender.Builder().id(uuid.getUUID()).name(name).build();
    }

}
