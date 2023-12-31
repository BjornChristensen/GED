package Live;

public class V2 {
    double x,y;

    V2(double x, double y){
        this.x=x;
        this.y=y;
    }

    V2 add(V2 v){
        return new V2(x+v.x, y+v.y);
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public static void main(String[] args) {
        V2 v1=new V2(3,5);
        V2 v2=new V2(1,2);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v1.add(v2));
    }
}
