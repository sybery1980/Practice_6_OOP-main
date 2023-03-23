public interface Format {
    <T extends Contact> String createString(T contact);
}