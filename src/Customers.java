public class Customers {
    private String name;
    private String adress;
    private String sex;
    private String email;
    private int phone;
    private int age;

    Customers(String name,
              String adress,
              int age,
              String sex,
              int phone,
              String email)
    {
        this.name = name;
        this.adress = adress;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.age = age;

    }






    public void showCustomers() {
        System.out.println("Imię i Nazwisko: " + name);
        System.out.println("Adres: " + adress);
        System.out.println("Wiek: " + age);
        System.out.println("Płeć: " + sex);
        System.out.println("Telefon: " + phone);
        System.out.println("E-mail: " + email);

    }

    public boolean checkName(String name) {
        return this.name == name;
    }

}