package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //TEST the empty constructor
    @Test
    public void testSettingJobId() {
        Job jobA = new Job();
        Job jobB = new Job();
        assertNotEquals(jobA.getId(), jobB.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getName(), "Product Tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality Control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }
    @Test
    public void testJobsForEquality() {
        Job jobC = new Job("a", new Employer("b"), new Location("c"), new PositionType("d"), new CoreCompetency("e"));
        Job jobD = new Job("a", new Employer("b"), new Location("c"), new PositionType("d"), new CoreCompetency("e"));
        assertFalse(jobC.equals(jobD));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobE = new Job("a", new Employer("b"), new Location("c"), new PositionType("d"), new CoreCompetency("e"));
        int n = jobE.toString().length();
        assertEquals(jobE.toString().charAt(0),'\n');
        assertEquals(jobE.toString().charAt(n - 1),'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobF = new Job("a", new Employer("b"), new Location("c"), new PositionType("d"), new CoreCompetency("e"));
        assertEquals(jobF.toString(), "\nID: " + jobF.getId() + "\n" + "Name: " + jobF.getName() + "\n" + "Employer: " + jobF.getEmployer().getValue() + "\n" + "Location: " + jobF.getLocation().getValue() + "\n" + "Position Type: " + jobF.getPositionType().getValue() + "\n" + "Core Competency: " + jobF.getCoreCompetency().getValue() + "\n");
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job jobG = new Job("a", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Job jobH = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(jobG.toString(), "\nID: " + jobG.getId() + "\nName: " + jobG.getName() + "\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n");
        assertEquals(jobH.toString(), "OOPS! This job does not seem to exist.");
    }
}
