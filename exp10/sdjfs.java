package exp10;

import java.util.Scanner;

class InvalidCredentialsException extends Exception {

    InvalidCredentialsException(String user) {
        super("Wrong password for user: " + user);
    }
}

class AccountLockedException extends Exception {

    AccountLockedException(String user, int min) {
        super("Account locked for user: " + user +
                " for " + min + " minutes");
    }
}

class LoginSystem {

    String users[][] = {
            {"admin", "1234"},
            {"cliff", "pass"}
    };

    int attempts[] = {0, 0};

    LoginSystem() {
    }

    LoginSystem(String u[][]) {
        users = u;
    }

    void login(String username, String password)
            throws InvalidCredentialsException,
            AccountLockedException {

        for (int i = 0; i < users.length; i++) {

            if (users[i][0].equals(username)) {

                if (attempts[i] >= 3) {
                    throw new AccountLockedException(username, 15);
                }

                if (users[i][1].equals(password)) {

                    System.out.println("Login Successful");
                    attempts[i] = 0;
                }

                else {

                    attempts[i]++;
                    throw new InvalidCredentialsException(username);
                }
            }
        }

        System.out.println("User not found");
    }

    int getAttempts(String username) {

        for (int i = 0; i < users.length; i++) {

            if (users[i][0].equals(username)) {
                return attempts[i];
            }
        }

        return 0;
    }

    public String toString() {

        return "Login System Ready";
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoginSystem ls = new LoginSystem();

        System.out.println(ls);

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nLogin Attempt " + i);

            System.out.print("Enter Username: ");
            String user = sc.next();

            System.out.print("Enter Password: ");
            String pass = sc.next();

            try {

                ls.login(user, pass);
            }

            catch (InvalidCredentialsException e) {

                System.out.println(e.getMessage());
            }

            catch (AccountLockedException e) {

                System.out.println(e.getMessage());
            }

            finally {

                System.out.println("Current Attempt Count: "
                        + ls.getAttempts(user));
            }
        }

        sc.close();
    }
}