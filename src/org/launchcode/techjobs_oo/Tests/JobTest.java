package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import org.junit.Before;

import static org.junit.Assert.*;
public class JobTest {
    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_jobEquality1;
    Job test_jobEquality2;

    @Before
    public void createJobObject(){
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_jobEquality1 = new Job("Eng1", new Employer("Comcast"), new Location("CTC Building"), new PositionType("IT"), new CoreCompetency("Java"));
        test_jobEquality2 = new Job( "Eng1", new Employer("Comcast"), new Location("CTC Building"), new PositionType("IT"), new CoreCompetency("Java"));
    }
    @Test
    public void testSettingJobId(){
        assertTrue(test_job1.getId() != test_job2.getId());
        assertTrue((test_job1.getId() + 1 == test_job2.getId()));
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(test_job1.getId() == 1);
        assertEquals("Product tester", test_job3.getName());
          assertTrue(test_job3.getEmployer() != null);
          assertTrue(test_job3.getLocation() instanceof Location);
          assertTrue(test_job3.getPositionType() != null);
          assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(test_jobEquality1.getId() == test_jobEquality2.getId());
    }
}

