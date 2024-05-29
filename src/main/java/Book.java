class Book extends Item {
    private int bookWidth;
    
    public Book(String name, int bookWidth) {
        super(name, TypeOfCarton.Book);
        this.bookWidth = bookWidth;
    }
    
    @Override
    public int getSize() {
        return this.bookWidth;
    }
}