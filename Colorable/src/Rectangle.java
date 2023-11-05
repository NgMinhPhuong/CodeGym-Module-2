public class Rectangle implements Resizeable<Integer>{
    public int width;
    public int height;
    Rectangle(int x , int y){
        this.width = x;
        this.height = y;
    }

    public Integer getR(){
        return this.width * this.height;
    }
    @Override
    public void resize(double percent) {
        this.width *= (percent/100);
        this.height *= (percent/100);
    }
}
