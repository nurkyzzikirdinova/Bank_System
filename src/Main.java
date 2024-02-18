import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = strequals("Картаныздын логини: ");
        String password = strequals("Пароль жазыныз: ");

        if (enter(username, password)) {

            Account my = new Account(0);
            Account account = new Account(1500);

            int choice;

            do {

                System.out.println("""
                        Сизге керектүү операцияны танданыз:
                        1. Баланс текшер
                        2. Депозит
                        3. Чыгарып алуу
                        4. Акча которуу
                        0. Чыгуу
                        Сан танданыз: 
                        """);

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("БАЛАНС" + my.checkBalance());
                        break;

                    case 2:
                        System.out.print("Акча салуунун суммасы: ");
                        double depositAmount = scanner.nextDouble();
                        my.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Акча алуунун суммасы: ");
                        double withdrawalAmount = scanner.nextDouble();
                        my.withdrawal(withdrawalAmount);
                        break;

                    case 4:
                        System.out.print("Акча которуунун суммасы: ");
                        double transactionAmount = scanner.nextDouble();
                        System.out.println("Кайсы картадан которуулат (1 - Сиздики, 2 - Башка): ");
                        int sendAccount = scanner.nextInt();

                        Account sender = (sendAccount == 1) ? my : account;

                        System.out.println("Кайсы картага которуу керек (1 - Сиздики, 2 - Башка): ");
                        int reciveAccount = scanner.nextInt();
                        Account recive = (reciveAccount == 1) ? my : account;

                        sender.transaction(recive, transactionAmount);
                        break;

                    case 0:
                        System.out.println("Программа токтотуу");
                        break;

                    default:
                        System.out.println("Мындай команда жок");
                }
            } while (choice != 0);


        } else {
            System.out.println("Туура эмес логин");
        }

    }
    private static boolean enter(String username, String password) {
        return username.equals("Nurkyz") && password.equals("parol");
    }

    private  static String strequals(String login) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(login);
        return scanner.nextLine();

    }
}

