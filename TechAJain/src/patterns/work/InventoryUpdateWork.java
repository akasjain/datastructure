package patterns.work;

import java.util.List;

public class InventoryUpdateWork<T> implements Work {

    private final T obj = null;
    List<Work> upstream;

    @Override
    public void perform() {

    }

    @Override
    public boolean commit() {
        return true;
    }

    @Override
    public T rollback() {
        return obj;
    }
}
