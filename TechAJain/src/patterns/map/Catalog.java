package patterns.map;

public class Catalog {
    public static void main(String[] args) {
        Map<Integer, Product> map = new MapImpl<>();
        map.put(2, new Product(2, "machine", "IFB", 20000.00f));
        map.put(18, new Product(18, "machine", "Bosch", 20000.00f));
        System.out.println(map.get(2).name);
        System.out.println(map.get(18).name);
    }
}
