package modis.students.console;

import modis.students.utils.StudentUtil;

import java.util.Scanner;

/**
 * Created by LEYED on 1/22/18.
 */
public class ConsoleManagerListener implements ConsoleManager{

    Scanner scanner = new Scanner(System.in);

    StudentUtil studentUtil;

    @Override
    public void startListeningCommands(StudentUtil studentUtil) {
        this.studentUtil = studentUtil;
        boolean listeningCommand = true;

        System.out.println("Welcome to the students UTILS API");

        while(listeningCommand == true) {
            System.out.println("PLEASE ENTER THE GRADUATION DATE FORMAT(YYYY-MM-DD): ");
            String highSchoolGradDate = scanner.next();
            System.out.println("PLEASE ENTER THE DATE TO EVALUATE (DEFAULT IS TODAY INSERT A \"-\" TO DO SO): ");
            String givenDate = scanner.next();

            try {
                System.out.println("THE CURRENT GRADE IS: " +
                        studentUtil.getGradeOnGivenDate(highSchoolGradDate, givenDate));
            } catch (Exception e) {
                System.out.println("INVALID INPUT PARAMETERS.");
            }
        }
    }
}
