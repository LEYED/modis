package modis.students.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LEYED on 1/22/18.
 */
public class StudentUtilImplementation implements StudentUtil {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private static int YEARS_TO_FINISH_HIGH_SCHOOL = 12;

    @Override
    public int getGradeOnGivenDate(String highSchoolGradDate, String givenDate) throws Exception {
        Calendar highSchoolGradCal = Calendar.getInstance();
        highSchoolGradCal.setTime(formatter.parse(highSchoolGradDate));

        Calendar givenCal = Calendar.getInstance();
        givenCal.setTime(givenDate.equals("-") ? new Date() : formatter.parse(givenDate));

        return getGradeOnGivenDate(highSchoolGradCal, givenCal);
    }

    private int getGradeOnGivenDate(Calendar highSchoolGradCal, Calendar givenCal) {
        int yearsDifference = (givenCal.get(Calendar.YEAR) - highSchoolGradCal.get(Calendar.YEAR));
        int currentGrade = YEARS_TO_FINISH_HIGH_SCHOOL - yearsDifference;
        return getCurrentGradeWithBoundsIndicator(currentGrade, highSchoolGradCal, givenCal);
    }

    private int getCurrentGradeWithBoundsIndicator(int currentGrade, Calendar highSchoolGradCal, Calendar givenCal) {
        if(givenCal.after(highSchoolGradCal)){
            return 99;
        }else if(currentGrade > YEARS_TO_FINISH_HIGH_SCHOOL){
            return -1;
        }else{
            return currentGrade;
        }
    }
}
