package ac.za.cput.repository.impl;

import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.repository.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepository repository;
    private HashSet<Gender> db;
    private GenderRepositoryImpl()
    {
        if(this.db == null) db = new HashSet<>();
    }

    public static GenderRepository getRepository()
    {
        if(repository==null) repository = new GenderRepositoryImpl();
        return repository;
    }

    private String objInSet(Gender gender)
    {
        String result = null;
        for(Gender t : this.db)
        {
            if(t.getName().equals(gender.getName()))
            {
                result = t.getId();
                break;
            }
        }
        return result;
    }

    @Override
    public Gender create(Gender gender) {
        String exists = objInSet(gender);
        if(exists == null)
        {
            this.db.add(gender);
            return gender;
        } else {
            return this.read(exists);
        }
    }

    @Override
    public Gender update(Gender gender) {
        Gender r = this.read(gender.getId());
        if(r!=null && this.delete(r))
        {
            this.db.add(gender);
            return gender;
        }
        return null;
    }

    @Override
    public Gender read(String s) {
        return this.db.stream().filter(r -> r.getId().trim().toLowerCase().equals(s.toLowerCase()))
                .findAny().orElse(null);
    }

    @Override
    public boolean delete(Gender gender) {
        String exists = objInSet(gender);
        if(exists != null)
        {
            this.db.remove(gender);
            return true;
        }
        return false;
    }
}
