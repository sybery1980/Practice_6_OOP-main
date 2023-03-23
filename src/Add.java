
import java.util.Scanner;
public class Add {
    private final Scanner scanner;
    public Add(Scanner scanner) {
        this.scanner = scanner;
    }
    public Contact makeNewContact() {
        System.out.println("Добавляем новую запись в <PhoneBook>.");
        System.out.println("Введите Фамилию / наименование Организации контакта:");
        String personLastName = scanner.nextLine();
        System.out.println("Введите Имя контакта:");
        String personFirstName = scanner.nextLine();
        System.out.println("Введите номер телефона контакта :");
        String number = scanner.nextLine();
        String comment = scanner.nextLine();
        System.out.println("Установите приоритет контакта: 1 - обычный, 2 - избранный:");
        String prior = scanner.nextLine();
        int priority = 0;
        if (prior.equals("1") | prior.equals("2")) {
            priority = Integer.parseInt(prior);
        } else {
            System.out.println("Ошибка ввода, приоритет не установлен, повторите ввод.\n");
        }
        System.out.println("Новая задача добавлена в список.\n");
        return new Contact(personLastName, personFirstName, number, priority, comment);
    }
}
