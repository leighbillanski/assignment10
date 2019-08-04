package ac.za.cput.service.impl;

import ac.za.cput.domain.demographics.Race;
import ac.za.cput.repository.RaceRepository;
import ac.za.cput.repository.impl.RaceRepositoryImpl;
import ac.za.cput.service.RaceService;

public class RaceServiceImpl implements RaceService {
    private static RaceService service;
    private RaceRepository repository;

    public static RaceService getService()
    {
        if(service == null) service = new RaceServiceImpl();
        return service;
    }
    private RaceServiceImpl()
    {
        if(repository==null) repository = RaceRepositoryImpl.getRepository();
    }
    @Override
    public Race create(Race race) {
        return this.repository.create(race);
    }

    @Override
    public Race read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Race update(Race race) {
        return this.repository.update(race);
    }

    @Override
    public boolean delete(Race race) {
        return this.repository.delete(race);
    }
}
