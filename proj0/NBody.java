public class NBody {
    public static double readRadius(String filename){

        In in = new In(filename);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String filename){
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();

        Body[] planets = new Body[N];
        for(int i=0;i<N;i++){

            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String file = in.readString();
            planets[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,file);
        }
        return planets;
    }
    public static String image = "images/starfield.jpg";

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];
        double radius = readRadius(filename);
        Body[] planets = readBodies(filename);
        int N = planets.length;


        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, image);
        for(Body b: planets){
            b.draw();
        }

        /** Enables double buffering for smooth animation rendering
         *  prevent it from flickering
         */
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while(time<T){
            double[] xForce = new double[N];
            double[] yForce = new double[N];
            for(int i=0;i<N;i++){
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i=0;i<N;i++){
                planets[i].update(dt,xForce[i],yForce[i]);
            }
            StdDraw.picture(0, 0, image);
            for(Body b: planets){
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
