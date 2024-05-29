class Ball extends Item {
    private int ballDiameter;
    
    public Ball(String name, int BallDiameter) {
        super(name, TypeOfCarton.Ball);
        this.ballDiameter = ballDiameter;
    }
    
    @Override
    public int getSize() {
        return this.ballDiameter;
    }
}