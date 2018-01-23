package modis.students;

import modis.students.console.ConsoleManager;
import modis.students.console.ConsoleManagerListener;
import modis.students.utils.StudentUtil;
import modis.students.utils.StudentUtilImplementation;

/**
 * Created by LEYED on 1/22/18.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleManager consoleManager = new ConsoleManagerListener();
        StudentUtil studentUtil = new StudentUtilImplementation();
        consoleManager.startListeningCommands(studentUtil);
    }
}
