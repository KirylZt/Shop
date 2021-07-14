public class IdError extends Exception{

    private int id;

    public IdError(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Товар с таким ID уже существует.";
    }
}
