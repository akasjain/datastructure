package patterns.work;

public interface Work<T> {
    void perform();

    boolean commit();

    T rollback();
}
