package ac.za.cput.domain.demographics;

public class Race {
    private String id, name;
    private Race(){}
    private Race(Builder builder)
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

    public static class Builder {
        private String id, name;
        public Builder name(String name)
        {
            this.name = name;
            return this;
        }
        public Builder id(String id)
        {
            this.id = id;
            return this;
        }
        public Builder copy(Race race)
        {
            this.name = race.name;
            this.id = race.id;
            return this;
        }
        public Race build()
        {
            return new Race(this);
        }


    }
}
