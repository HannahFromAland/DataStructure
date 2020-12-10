public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b){
        return Math.sqrt(Math.pow(b.xxPos - this.xxPos, 2) + Math.pow(b.yyPos - this.yyPos, 2));
    }
    public double calcForceExertedBy(Body b){
        double dis = calcDistance(b);
        return 6.67 * Math.pow(10, -11) * this.mass * b.mass /(Math.pow(dis,2));
    }
    public double calcForceExertedByX(Body b){
        double total = calcForceExertedBy(b);
        double dis = calcDistance(b);
        return total*(b.xxPos-this.xxPos)/dis;
    }

    public double calcForceExertedByY(Body b){
        double total = calcForceExertedBy(b);
        double dis = calcDistance(b);
        return total*(b.yyPos-this.yyPos)/dis;
    }
    public double calcNetForceExertedByX(Body[] allbodys){
        double netforce = 0;
        for(Body b: allbodys){
            if(!this.equals(b)){
                netforce += calcForceExertedByX(b);
            }
        }
        return netforce;
    }

    public double calcNetForceExertedByY(Body[] allbodys){
        double netforce = 0;
        for(Body b: allbodys){
            if(!this.equals(b)){
                netforce += calcForceExertedByY(b);
            }
        }
        return netforce;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX/this.mass;
        double aY = fY/this.mass;

        this.xxVel += aX * dt;
        this.yyVel += aY * dt;

        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
