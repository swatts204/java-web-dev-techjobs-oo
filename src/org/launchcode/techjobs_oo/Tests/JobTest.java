package org.launchcode.techjobs_oo.Tests;

import org.junit.After;
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
    @After
    public void clearJobObjects(){
        Job.resetId();

    }
    @Test
    public void testSettingJobId(){
        assertTrue((test_job1.getId() + 1 == test_job2.getId()));

    }
    @Test
    public void testJobConstructorSetsAllFields(){
          assertTrue(test_job3 instanceof Job);
          assertEquals(3,test_job3.getId());
          assertEquals("Product tester", test_job3.getName());
          assertEquals("ACME", test_job3.getEmployer().getValue());
          assertEquals("Desert",test_job3.getLocation().getValue());
          assertEquals("Quality control",test_job3.getPositionType().getValue());
          assertEquals("Persistence",test_job3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        assertNotEquals(test_jobEquality1.getId(), test_jobEquality2.getId());
    }
    //.equals()
    @Test
    public void testToStringStartsAndEndsWithNextLine(){
        char firstChar = test_job3.toString().charAt(0);
        char lastChar = test_job3.toString().charAt(test_job3.toString().length()-1);

        assertTrue(firstChar == lastChar);

    }
    @Test
    public void testToString(){
        String testString = "\n" + "ID: " + test_job3.getId() + "\n" + "Name: " + test_job3.getName() + "\n" + "Employer: " + test_job3.getEmployer() + "\n" + "Location: " + test_job3.getLocation() + "\n" + "Position Type: " + test_job3.getPositionType() + "\n" + "Core Competency: " + test_job3.getCoreCompetency() + "\n";
        assertEquals(testString, test_job3.toString());
    }
    @Test
    public void testToStringWithEmptyField(){
        test_job3.getCoreCompetency().setValue("");
        test_job3.getLocation().setValue("");
        String testString = "\n" + "ID: " + test_job3.getId() + "\n" + "Name: " + test_job3.getName() + "\n" + "Employer: " + test_job3.getEmployer() + "\n" + "Location: Data not available" + "\n" + "Position Type: " + test_job3.getPositionType() + "\n" + "Core Competency: Data not available";
        assertEquals(testString,test_job3.toString());
    }
}

