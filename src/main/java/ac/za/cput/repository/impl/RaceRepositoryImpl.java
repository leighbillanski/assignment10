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

    @Override
    public Race create(Race race) {
        this.db.add(race);
        return race;
    }

    @Override
    public Race update(Race race) {
        Race r = this.read(race.getName());
        if(r!=null && this.delete(r))
        {
            this.db.add(race);
            return race;
        }
        return null;
    }

    @Override
    public Race read(String s) {
        return this.db.stream().filter(r -> r.getName().toLowerCase().equals(s))
                .findAny().orElse(null);
    }

    @Override
    public boolean delete(Race race) {
        Race r = this.read(race.getName());
        if(r != null)
        {
            this.db.remove(r);
            return true;
        }
        return false;
    }
}
