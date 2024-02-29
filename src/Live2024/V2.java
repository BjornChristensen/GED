package Live2024;

public class V2 {
    double x,y;

    V2(double x, double y){
        this.x=x;
        this.y=y;
    }

    V2 add(V2 v) {
        return new V2(x+ v.x, y+ v.y);
    }

    V2 sub(V2 v) {
        return new V2(x- v.x, y- v.y);
    }

    V2 mul(double s){
        return new V2(s*x, s*y);
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public static void main(String[] args) {
        V2 v1=new V2(1,2);
        V2 v2=new V2(3,5);
        V2 v3=v1.add(v2);
        System.out.println("v1="+v1);
        System.out.println("v2="+v2);
        System.out.println("v3="+v3);

    }
}
