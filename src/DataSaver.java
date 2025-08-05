import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idNumber = 1;
        boolean done = false;

        while (!done) {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter first name: ");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter last name: ");
            String id = String.format("%06d", idNumber);
            String email = SafeInput.getNonZeroLenString(in, "Enter email: ");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter year of birth", 1909, 2025);

            String storedInfoStr = firstName + " | " + lastName + " | " + id + " | " + email + " | " + yearOfBirth;
            records.add(storedInfoStr);
            idNumber++;


            boolean continueAdding = SafeInput.getYNConfirm(in, "Would you like to add another entry?");
            if (!continueAdding) {
                done = true;
            }
        }

        boolean exit = false;
        while (!exit) {
            String fileName = SafeInput.getNonZeroLenString(in, "Enter filename you wish to save: ");
            fileName = fileName + ".csv";

            try {
                FileWriter writer = new FileWriter("src/" + fileName);
                for (String rec : records) {
                    writer.write(rec + "\n");
                }
                writer.close();

                System.out.println(fileName + " Saved");
                exit = true;
            }
            catch (IOException e) {
                System.out.println("Error writing to file: please try again");
            }
        }

        in.close();
    }
}