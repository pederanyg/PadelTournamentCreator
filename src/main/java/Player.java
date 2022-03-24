public class Player {

    public String firstName;
    public String lastName;
    public int age;
    public String gender;

    public Player(String firstName, String lastName, int age, String gender){
        if (firstName.isBlank()||lastName.isBlank()){throw new IllegalArgumentException("The player needs a full name!");}
        if (age<0){throw new IllegalArgumentException("The player cannot be lower than 0.");}
        if (gender.isBlank()){throw new IllegalArgumentException("The gender must be spesified.");}
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setName(String firstName, String lastName) {
        if (firstName.isBlank()||lastName.isBlank()){throw new IllegalArgumentException("The player needs a full name!");}
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){throw new IllegalArgumentException("The player cannot be lower than 0.");}
        this.age=age;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender) {
        if (gender.isBlank()){throw new IllegalArgumentException("The gender must be spesified.");}
        this.gender = gender;
    }
}
