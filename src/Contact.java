
public class Contact implements Comparable<Contact> {
    private String personLastName;
    private String personFirstName;
    private String number;
    private String comment;
    private int priority;
    private final int id;
    private static int count;
    static {
        count = 0;
    }
    public Contact(String personLastName, String personFirstName, String number, int priority, String comment) {
        this.personLastName = personLastName;
        this.personFirstName = personFirstName;
        this.number = number;
        this.priority = priority;
        this.comment = comment;
        this.id = ++count;
    }
    public String getPersonLastName() {
        return personLastName;
    }
    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }
    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getPriority() {
        return switch (priority) {
            case 1 -> "Обычный контакт";
            case 2 -> "Избранный контакт";
            default -> "Не установлен";
        };
    }

    public int getPriorCode() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "№(ID) " + getId() +
                "  Фамилия / Наименование: " + getPersonLastName() +
                "  Имя: " + getPersonFirstName() +
                ", Телефон: " + getNumber() +
                ", Приоритет: " + getPriority() +
                ", Комментарий: " + getComment();
    }

    @Override
    public int compareTo(Contact o) {
        int compareId
                = o.getId();
        return this.id - compareId;
    }
}