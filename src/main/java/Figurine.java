class Figurine extends Item {
    private int figurineHight;
    
    public Figurine(String name, int figurineHight) {
        super(name, TypeOfCarton.Figurine);
        this.figurineHight = figurineHight;
    }
    
    @Override
    public int getSize() {
        return this.figurineHight;
    }
}