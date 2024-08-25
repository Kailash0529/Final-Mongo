package semi.minor.pro.constants;



public enum UserType {
    STUDENT("student"),
    INSTRUCTOR("instructor");

    private final String value;

    UserType(String value) {
        this.value = value;
    }


}