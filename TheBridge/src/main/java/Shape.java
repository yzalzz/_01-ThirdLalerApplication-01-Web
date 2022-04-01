public abstract class Shape {
    //抽象类里面要依赖与接口
    protected ColorAPI colorAPI;
    public void setDrawAPI(ColorAPI colorAPI){
        this.colorAPI=colorAPI;
    }
    public abstract void draw();


}
