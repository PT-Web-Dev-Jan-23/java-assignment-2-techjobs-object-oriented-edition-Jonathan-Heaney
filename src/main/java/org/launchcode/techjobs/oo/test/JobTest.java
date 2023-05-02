package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId () {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1, testJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job productTester = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(productTester.getName() instanceof String);
        assertTrue(productTester.getEmployer() instanceof Employer);
        assertTrue(productTester.getLocation() instanceof Location);
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(productTester.getName(), "Product tester");
        assertEquals(productTester.getEmployer().toString(), "ACME");
        assertEquals(productTester.getLocation().toString(), "Desert");
        assertEquals(productTester.getPositionType().toString(), "Quality control");
        assertEquals(productTester.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job productTester = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobString = productTester.toString();
        char firstCharacter = jobString.charAt(0);
        char lastCharacter = jobString.charAt(jobString.length() - 1);
        assertEquals(firstCharacter,'\n');
        assertEquals(lastCharacter,'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job productTester = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobString = productTester.toString();
        assertTrue(jobString.contains("ID: " + productTester.getId()));
        assertTrue(jobString.contains("Name: " + productTester.getName().toString()));
        assertTrue(jobString.contains("Employer: " + productTester.getEmployer().toString()));
        assertTrue(jobString.contains("Location: " + productTester.getLocation().toString()));
        assertTrue(jobString.contains("Position Type: " + productTester.getPositionType().toString()));
        assertTrue(jobString.contains("Core Competency: " + productTester.getCoreCompetency().toString()));
        assertEquals(jobString, "\n" +
                "ID: " + productTester.getId() +
                "\nName: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n");

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job productTester = new Job("Product tester", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));
        String jobString = productTester.toString();
        assertTrue(jobString.contains("Name: " + productTester.getName().toString()));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
        assertEquals(jobString, "\n" +
                "ID: " + productTester.getId() +
                "\nName: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n");
    }
}
