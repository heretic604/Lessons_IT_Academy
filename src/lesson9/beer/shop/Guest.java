package lesson9.beer.shop;

import lesson9.exceptions.IncorrectAgeException;
import lesson9.exceptions.IncorrectEmailException;

import java.util.Scanner;

public class Guest {

    private String email;
    private int age;
    private boolean successRegistration;

    public Guest() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите email: ");
        this.email = scanner.nextLine();
        System.out.println("Сколько вам лет?");
        this.age = scanner.nextInt();

        try {
            if (!email.contains("@")) {
                throw new IncorrectEmailException();
            } else if (age < 21) {
                throw new IncorrectAgeException();
            } else {
                successRegistration = true;
            }

        } catch (IncorrectAgeException | IncorrectEmailException e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.printf("Successful registration: %s\n", successRegistration);
        }
    }

    public boolean isSuccessRegistration() {
        return successRegistration;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSuccessRegistration(boolean successRegistration) {
        this.successRegistration = successRegistration;
    }
}
