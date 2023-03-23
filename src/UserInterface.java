import java.util.Scanner;
public class UserInterface {

    private final Scanner scanner;
    private final Menu menu;
    private final Book book;
    private final Add add;
    private final FileReader fileReader;
    protected static String csvPath = "/Users/sybery/IdeaProjects/Practice_6_OOP/src/Book.csv";
    protected static String jsonPath = "/Users/sybery/IdeaProjects/Practice_6_OOP/src/Book.json";


    public UserInterface(Scanner scanner, Menu menu, Book book, Add add, FileReader fileReader) {
        this.scanner = scanner;
        this.menu = menu;
        this.book = book;
        this.add = add;
        this.fileReader = fileReader;
    }

    public void start() {

        while (true) {
            switch (menu.selectFunction()) {
                case "1":
                    System.out.println("\nСписок всех контактов:");
                    book.sort();
                    book.showAll();
                    System.out.println("");
                    break;
                case "2":
                    System.out.print("Введите Фамилию или наименование Организации контакта: ");
                    System.out.println(book.getByLastName(scanner.nextLine()));
                    System.out.println("");
                    break;
                case "3":
                    System.out.print("Введите номер телефона контакта, в формате 79111234567: ");
                    System.out.println(book.getByNumber(scanner.nextLine()));
                    System.out.println("");
                    break;
                case "4":
                    System.out.print("\nВведите ключевое слово для поиска контакта (например родство, профессия и пр.): ");
                    book.totalSearch(scanner.nextLine());
                    System.out.println("");
                    break;
                case "5":
                    System.out.println("\nОтсортированный список контактов по приоритетам - сначала избранные, потом обычные:");
                    book.sortByPrior();
                    book.showAll();
                    System.out.println("");
                    break;
                case "6":
                    saveFile();
                    break;
                case "7":
                    fileReader.fileReader();
                    break;
                case "8":
                    book.add(add.makeNewContact());
                    break;
                case "9":
                    System.out.println("Введите номер (ID) записи в справочнике, которую необходимо изменить: ");
                    changeContact(book.getById((scanner.nextInt())));
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
            }
        }
    }

    public void saveFile() {
        BookIterator bookIterator = new BookIterator(book);
        while (true) {
            switch (menu.selectSaveType()) {
                case "1" ->
                {
                    while (bookIterator.hasNext()) {
                        SaveModel<Contact> saved = new SaveModel<>(bookIterator.next());
                        saved.setFormat(new CsvWriter());
                        saved.setPath(csvPath);
                        saved.save();
                    }
                    System.out.println("\nКонтакты справочника сохранены в файл формата <CSV>.\n");
                }
                case "2" ->
                {
                    while (bookIterator.hasNext()) {
                        SaveModel<Contact> saved = new SaveModel<>(bookIterator.next());
                        saved.setFormat(new JsonWriter());
                        saved.setPath(jsonPath);
                        saved.save();
                    }
                    System.out.print("\nКонтакты справочника сохранены в файл формата <JSON>.\n");
                }

                case "3" ->
                        start();
                case "0" ->
                        System.exit(0);
                default -> {
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
                }
            }
        }
    }

    public void changeContact(Contact changing) {
        while (true) {
            switch (menu.selectContactChange()) {
                case "1" -> {
                    System.out.println("Введите новую Фамилию или наименование Организации контакта: ");
                    changing.setPersonLastName(scanner.nextLine());
                }
                case "2" -> {
                    System.out.println("Введите новое Имя контакта: ");
                    changing.setPersonFirstName(scanner.nextLine());
                }
                case "3" -> {
                    System.out.print("Введите новый номер телефона: ");
                    changing.setNumber(scanner.nextLine());
                }
                case "4" -> {
                    System.out.print("Введите новый приоритет контакта: 1 - обычный, 2 - избранный: ");
                    changing.setPriority(scanner.nextInt());
                }
                case "5" -> {
                    System.out.print("Введите новый комментарий к записи контакта (родство, профессия, место работы и пр.): ");
                    changing.setComment(scanner.nextLine());
                }
                case "6" ->
                        start();
                case "0" ->
                        System.exit(0);
                default -> {
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
                }
            }
        }
    }
}
