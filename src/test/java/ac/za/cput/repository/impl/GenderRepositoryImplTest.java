package ac.za.cput.repository.impl;

import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.factory.demographics.GenderFactory;
import ac.za.cput.repository.GenderRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderRepositoryImplTest {
    GenderRepository repository;
    Gender gender;

    @Before
    public void setUp() throws Exception {
        repository = GenderRepositoryImpl.getRepository();
        gender = GenderFactory.getGender("Male");
    }

    @Test
    public void create() {
        Gender test = this.repository.create(gender);
        assertNotNull(test);
        assertEquals(test.getName(), gender.getName());
    }

    @Test
    public void update() {
        create();
        Gender n = new Gender.Builder().copy(this.gender).name("Female").build();
        Gender upd = this.repository.update(n);
        assertNotSame(gender, upd);
        assertEquals("Female", upd.getName());
    }

    @Test
    public void read() {
        create();
        assertSame(gender, this.repository.read(gender.getId()));
    }

    @Test
    public void delete() {
        create();
        boolean res = this.repository.delete(this.gender);
        assertTrue(res);
        assertNull(this.repository.read(this.gender.getId()));
    }
}