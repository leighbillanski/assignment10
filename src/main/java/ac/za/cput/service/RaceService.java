package ac.za.cput.service;

import ac.za.cput.domain.demographics.Race;

import java.util.List;

public interface RaceService extends IService<Race, String> {
    List getEmployees(Race race);
}
