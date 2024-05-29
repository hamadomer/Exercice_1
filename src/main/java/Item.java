abstract class Item {
    private String name;
    private int size;
    private TypeOfCarton typeOfCarton;

    public Item(String name, int size, TypeOfCarton typeOfCarton) {
        this.name = name;
        this.size = size;
        this.typeOfCarton = typeOfCarton;
    }
    
    public Item(String name, TypeOfCarton typeOfCarton) {
        this.name = name;
        this.typeOfCarton = typeOfCarton;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public TypeOfCarton getTypeOfCarton() {
        return typeOfCarton;
    }
}