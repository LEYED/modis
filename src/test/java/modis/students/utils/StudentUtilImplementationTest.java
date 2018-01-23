package modis.students.utils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by LEYED on 1/22/18.
 */
public class StudentUtilImplementationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    StudentUtilImplementation studentUtilImplementation;

    @Before
    public void setup(){
        studentUtilImplementation = new StudentUtilImplementation();
    }

    @Test
    public void getGradeOnGivenDate() throws Exception {
        ArrayList<TestingData> testData = new ArrayList<>();
        testData.add(new TestingData("2016-06-02", "2016-06-02", 12));
        testData.add(new TestingData("2016-06-02", "2000-06-02", -1));
        testData.add(new TestingData("2016-06-02", "2016-06-03", 99));
        for(TestingData item: testData){
            assert studentUtilImplementation.getGradeOnGivenDate
                    (item.highSchoolGradDateDate, item.givenDate) == item.expectedResult;
        }
    }

    @Test
    public void testException() throws Exception{
        thrown.expect(Exception.class);
        studentUtilImplementation.getGradeOnGivenDate("2016-01", "-");
    }

    private class TestingData {
        private String highSchoolGradDateDate;
        private String givenDate;
        private int expectedResult;

        public TestingData(String highSchoolGradDateDate, String givenDate, int expectedResult) {
            this.highSchoolGradDateDate = highSchoolGradDateDate;
            this.givenDate = givenDate;
            this.expectedResult = expectedResult;
        }

        public String getHighSchoolGradDateDate() {
            return highSchoolGradDateDate;
        }

        public void setHighSchoolGradDateDate(String highSchoolGradDateDate) {
            this.highSchoolGradDateDate = highSchoolGradDateDate;
        }

        public String getGivenDate() {
            return givenDate;
        }

        public void setGivenDate(String givenDate) {
            this.givenDate = givenDate;
        }

        public int getExpectedResult() {
            return expectedResult;
        }

        public void setExpectedResult(int expectedResult) {
            this.expectedResult = expectedResult;
        }
    }


}