import java.util.*;

class Main {

    public static void main(String[] args){

        ArrItem<String> arr = new ArrItem<>();
        arr.add(new Item<>("Apple"));
        arr.add(new Item<>("Banana"));
        arr.add(new Item<>("Cherry"));
        StringBuilder out = new StringBuilder("[ ");
        for (Item<String> item : arr){
            out.append(String.format("%-10s", item));
            out.append(" ,");
        }
        out.delete(out.length()-2, out.length());
        out.append(" ]");
        System.out.println(out);

    }
}

