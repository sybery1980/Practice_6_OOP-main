import java.util.Scanner;

public class Controller {
    public static void run(){
        Contact c1 = new Contact("Родионова", "Анна","79111234567", 2,"Продавец");
        Contact c2 = new Contact("Павлов", "Валера","79311234567", 1,"Дворник");
        Contact c3 = new Contact("Семенова", "Ольга","79211234567", 2,"Банкирша");
        Contact c4 = new Contact("Ломонова", "Валя","79901234567", 2,"Соседка");
        Contact c5 = new Contact("Ларцова", "Света","79121234567",1,"Напарница");
        Book myBook = new Book();
        myBook.add(c1);
        myBook.add(c2);
        myBook.add(c3);
        myBook.add(c4);
        myBook.add(c5);
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Add add = new Add(scanner);
        FileReader fileReader = new FileReader(scanner);
        UserInterface userInterface = new UserInterface(scanner, menu, myBook, add, fileReader);
        userInterface.start();
    }
}
