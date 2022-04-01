public class test {
    public static void main(String[] args) {
       Shape shape= new Circle();
        BlueColorAPI blueColorAPI = new BlueColorAPI();
        shape.setDrawAPI(blueColorAPI);
        shape.draw();

        System.out.println("__________________________");
        //创建一个长方形
        Shape shape1 = new Rectangl();
        //给长方形红色的颜料
        shape1.setDrawAPI(new RedColorAPI());
        //上色
        shape1.draw();


        System.out.println("---------------------");

       Shape shape2 = new San();
       shape2.setDrawAPI(new RedColorAPI());
       shape2.draw();

    }
    }

