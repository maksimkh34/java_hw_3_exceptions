public class Model {
    public static int isDataCorrect(String data) {
        if(data.split(" ").length == 6) return 0;
        else if(data.split(" ").length > 6) return -1;
        else if(data.split(" ").length < 6) return -2;
        return -3;
    }

    public static DataObj tryParse(String data) throws IncorrectFormat {
            String[] data_arr = data.split(" ");

            String surname = data_arr[0];
            String name = data_arr[1];
            String second_name = data_arr[2];
            String date_of_birth = data_arr[3];
            String phone_number_str = data_arr[4];

            char sex;

            try {
                sex = data_arr[5].charAt(0);
                if(sex != 'f' && sex != 'm' || data_arr[5].length() > 1)
                    throw new IncorrectFormat("Incorrect data given. ");
            } catch (Exception e) {
                throw new IncorrectFormat("Incorrect sex given. ");
            }

            int dob_day, dob_month, dob_year;

            try {
                String[] dob_arr = date_of_birth.split("\\.");

                dob_day = Integer.parseInt(dob_arr[0]);
                dob_month = Integer.parseInt(dob_arr[1]);
                dob_year = Integer.parseInt(dob_arr[2]);
            } catch (Exception e) {
                throw new IncorrectFormat("Incorrect date of birth given. ");
            }

            long phone_number;
            try {
                phone_number = Long.parseLong(phone_number_str);
            } catch (Exception e) {
                throw new IncorrectFormat("Incorrect phone number given. ");
            }

            return new DataObj(
                    name, surname, second_name, dob_day, dob_month, dob_year, phone_number, sex
            );

    }
}
