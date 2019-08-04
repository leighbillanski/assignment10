package ac.za.cput.repository.impl;

import ac.za.cput.domain.demographics.Race;
import ac.za.cput.factory.demographics.RaceFactory;
import ac.za.cput.repository.RaceRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceRepositoryImplTest {

    RaceRepository repository;
    Race race;

    @Before
    public void setUp() throws Exception {
        repository = RaceRepositoryImpl.getRepository();
        race = RaceFactory.getRace("Male");
    }

    @Test
    public void create() {
        Race test = this.repository.create(race);
        assertNotNull(test);
        assertEquals(test.getName(), race.getName());
    }

    @Test
    public void update() {
        create();
        Race n = new Race.Builder().copy(this.race).name("Female").build();
        Race upd = this.repository.update(n);
        assertNotSame(race, upd);
        assertEquals("Female", upd.getName());
    }

    @Test
    public void read() {
        create();
        assertSame(race, this.repository.read(race.getId()));
    }

    @Test
    public void delete() {
        create();
        boolean res = this.repository.delete(this.race);
        assertTrue(res);
        assertNull(this.repository.read(this.race.getId()));
    }
}