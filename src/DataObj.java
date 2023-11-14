public class DataObj {
    String name;
    String surname;
    String second_name;
    int dob_day;
    int dob_month;
    int dob_year;
    long phone_number;
    char sex;

    DataObj(String name, String surname, String second_name,
            int dob_day, int dob_month, int dob_year, long phone_number,
            char sex) {
        this.name = name;
        this.surname = surname;
        this.second_name = second_name;

        this.phone_number = phone_number;
        this.sex = sex;

        this.dob_day = dob_day;
        this.dob_month = dob_month;
        this.dob_year = dob_year;
    }
}
