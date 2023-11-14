import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Data: ");
        String data = sc.nextLine();

        switch (Model.isDataCorrect(data)) {
            case 0:
                System.out.println("Quantity is correct... ");
                break;
            case -1:
                System.out.println("Too much! ");
                System.exit(-1);
                break;
            case -2:
                System.out.println("Too few! ");
                System.exit(-1);
                break;
            case -3:
                System.out.println("Unknown error... ");
                System.exit(-1);
                break;
        }

        try {
            DataObj human = Model.tryParse(data);
            System.out.println("Parsing finished! ");

            StringBuilder string_output = new StringBuilder();
            string_output.append(human.surname).append(human.name).append(human.second_name)
                    .append(human.dob_day).append(human.dob_month).append(human.dob_year)
                    .append(human.phone_number).append(human.sex).append("\n");


            try (FileOutputStream outputStream = new FileOutputStream(human.surname, true)) {
                byte[] strToBytes = string_output.toString().getBytes();
                outputStream.write(strToBytes);
            } catch (IOException e) {
                System.out.println("Error! ");
            }


        } catch (IncorrectFormat e) {
            System.out.println("Error while parsing data: " + e.getMessage());
        }
    }
}