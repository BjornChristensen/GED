package Live;

import java.awt.*;

public class S2 {
    static final V2 Origo=new V2(0,0);
    V2 O;
    M2 S;
    M2 F;
    M2 T;

    S2(int sx, int sy, int ox, int oy){
        O=new V2(ox,oy);
        F=new M2(1, 0,
                 0,-1);
        S=new M2(sx,  0,
                  0, sy);
        T=F.mul(S);
    }

    V2 transform(V2 v){
        return T.mul(v).add(O);
    }

    void drawLine(Graphics g, V2 p1, V2 p2){
        V2 pp1=transform(p1);   // point in pixels
        V2 pp2=transform(p2);   // point in pixels
        g.drawLine((int)pp1.x, (int)pp1.y, (int)pp2.x, (int)pp2.y);
    }

    void drawString(Graphics g, String text, V2 p){
        V2 pp=transform(p);   // point in pixels
        g.drawString(text, (int)pp.x, (int)pp.y);
    }

    void drawAxis(Graphics g){
        drawLine(g, Origo, new V2(1,0));
        drawLine(g, Origo, new V2(0,1));
    }
}
