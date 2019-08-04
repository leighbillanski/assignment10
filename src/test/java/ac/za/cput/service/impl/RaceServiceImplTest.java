package ac.za.cput.service.impl;

import ac.za.cput.domain.demographics.Race;
import ac.za.cput.factory.demographics.RaceFactory;
import ac.za.cput.service.RaceService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceServiceImplTest {
    private RaceService service;
    private Race race;

    @Before
    public void setUp() throws Exception {
        service = RaceServiceImpl.getService();
        race = RaceFactory.getRace("Male");
    }

    @Test
    public void create() {
        Race t = this.service.create(race);
        assertEquals(t.getId(), race.getId());
    }

    @Test
    public void read() {
        create();
        Race t = this.service.read(race.getId());
        assertNotNull(t);
    }

    @Test
    public void update() {
        create();
        Race newg = new Race.Builder().copy(race).name("Female").build();
        Race t = this.service.update(newg);
        assertNotNull(t);
        assertEquals("Female", t.getName());
    }

    @Test
    public void delete() {
        create();
        boolean res = this.service.delete(race);
        assertTrue(res);
        assertNull(this.service.read(race.getId()));
    }
}