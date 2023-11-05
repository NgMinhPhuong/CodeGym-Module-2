public class Square implements Resizeable<Integer>, Colorable {
    public int canh;
    Square(int x){
        this.canh = x;
    }

    @Override
    public void resize(double percent) {
        this.canh *= (percent/100);
    }

    public Integer getR(){
        return canh * canh;
    }
    @Override
    public void howToColor() {
        System.out.println("Square here");
    }
}
