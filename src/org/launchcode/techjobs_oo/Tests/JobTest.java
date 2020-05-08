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
         // assertEquals(,test_job3.getId());
          assertTrue(test_job2.getId()< test_job3.getId());
          assertEquals("Product tester", test_job3.getName());
          assertTrue(test_job3.getEmployer() != null);
          assertTrue(test_job3.getLocation() instanceof Location);
          assertTrue(test_job3.getPositionType() != null);
          assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        assertNotEquals(test_jobEquality1.getId(), test_jobEquality2.getId());
    }
    @Test
    public void jobTest(){
        String testString = "\n" + "ID: " +
                test_jobEquality1.getId() + "\n" + "Name: " + test_jobEquality1.getName() + "\n" + "Employer: " + test_jobEquality1.getEmployer() + "\n" + "Location: " + test_jobEquality1.getLocation() + "\n" + "Position Type: " + test_jobEquality1.getPositionType() + "\n" + "Core Competency: " + test_jobEquality1.getCoreCompetency() + "\n";
        assertEquals(testString, test_jobEquality1.toString());
        String testStringNA = "\n" + "ID: " + test_job1.getId() + "\n" + "Name: Data not available" + "\n" + "Employer: Data not available" + "\n" + "Location: Data not available"+ "\n" + "Position Type: Data not available" + "\n" + "Core Competency: Data not available" + "\n";
        assertEquals(testStringNA, testStringNA.toString());
    }
}

