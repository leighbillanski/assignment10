package ac.za.cput.domain.demographics;

import com.sun.tools.javah.Gen;

public class Gender {
    private String id, name;
    private Gender(){}
    private Gender(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public static class Builder{
        private String id, name;
        public Builder id(String id)
        {
            this.id = id;
            return this;
        }
        public Builder name(String name)
        {
            this.name = name;
            return this;
        }
        public Gender build()
        {
            return new Gender(this);
        }
    }
}
