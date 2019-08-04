package ac.za.cput.service.impl;

import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.factory.demographics.GenderFactory;
import ac.za.cput.service.GenderService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderServiceImplTest {
    private GenderService service;
    private Gender gender;

    @Before
    public void setUp() throws Exception {
        service = GenderServiceImpl.getService();
        gender = GenderFactory.getGender("Male");
    }

    @Test
    public void create() {
        Gender t = this.service.create(gender);
        assertEquals(t.getId(), gender.getId());
    }

    @Test
    public void read() {
        create();
        Gender t = this.service.read(gender.getId());
        assertNotNull(t);
    }

    @Test
    public void update() {
        create();
        Gender newg = new Gender.Builder().copy(gender).name("Female").build();
        Gender t = this.service.update(newg);
        assertNotNull(t);
        assertEquals("Female", t.getName());
    }

    @Test
    public void delete() {
        create();
        boolean res = this.service.delete(gender);
        assertTrue(res);
        assertNull(this.service.read(gender.getId()));
    }
}