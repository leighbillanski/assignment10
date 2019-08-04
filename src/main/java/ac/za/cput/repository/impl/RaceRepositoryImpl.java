package ac.za.cput.repository.impl;

import ac.za.cput.domain.demographics.Race;
import ac.za.cput.repository.RaceRepository;

import java.util.HashSet;

public class RaceRepositoryImpl implements RaceRepository {
    private static RaceRepository repository;
    private HashSet<Race> db;

    private RaceRepositoryImpl(){
        this.db = new HashSet<>();
    }
    public static RaceRepository getRepository()
    {
        if(repository==null) repository = new RaceRepositoryImpl();
        return repository;
    }

    private String objInSet(Race race)
    {
        String result = null;
        for(Race t : this.db)
        {
            if(t.getName().equals(race.getName()))
            {
                result = t.getId();
                break;
            }
        }
        return result;
    }

    @Override
    public Race create(Race race) {
        String exists = objInSet(race);
        if(exists == null)
        {
            this.db.add(race);
            return race;
        } else {
            return this.read(exists);
        }
    }

    @Override
    public Race update(Race race) {
        Race r = this.read(race.getId());
        if(r!=null && this.delete(r))
        {
            this.db.add(race);
            return race;
        }
        return null;
    }

    @Override
    public Race read(String s) {
        return this.db.stream().filter(r -> r.getId().trim().toLowerCase().equals(s.toLowerCase()))
                .findAny().orElse(null);
    }

    @Override
    public boolean delete(Race race) {
        String exists = objInSet(race);
        if(exists != null)
        {
            this.db.remove(race);
            return true;
        }
        return false;
    }
}
