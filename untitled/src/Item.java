public class Item<T>{
    private T item;

    public Item(T item){
        this.item = item;
    }
    public T getItem(){
        return item;
    }
    public void setItem(T item){
        this.item = item;
    }
    public String toString(){
        return item.toString();
    }

}
