class Cloth extends Item {
    private int clothWidth;
    
    public Cloth(String name, int clothWidth) {
        super(name, TypeOfCarton.Cloth);
        this.clothWidth = clothWidth;
    }
    
    @Override
    public int getSize() {
        return this.clothWidth;
    }
}