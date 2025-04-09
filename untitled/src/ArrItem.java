import java.util.ArrayList;

public class ArrItem<T> extends ArrayList<Item<T>> {

    @Override
    public boolean add(Item<T> item) {
        // Custom behavior: e.g. log before adding
        System.out.println("Adding item: " + item);
        return super.add(item); // call the actual add method from ArrayList
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            sb.append(get(i));
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}