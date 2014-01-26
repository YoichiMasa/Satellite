import java.util.Scanner;

/**
 *
 * @author Octavio Gutierrez
 */
public class SatelliteDriver {

    public static void main(String[] args) {
        //default values of Canada's Alouette I Satelite Launched in 1962
    	Satellite dibit = new Satellite();
    	Scanner stdin = new Scanner(System.in);
        int orbitTime;
        String response;
        int interval = 1;
        
        dibit.setX(42280000);
        dibit.setY(0);
        dibit.setVx(0);
        dibit.setVy(3074);
        System.out.println(dibit.getOrbitalPeriod());
        System.out.print("How many seconds of orbit data would you like? ");
        orbitTime = stdin.nextInt();
        
        System.out.print("Data interval is one second, would you like to specify another value? (yes | no) ");
        response = stdin.next();
        
        if (response.equals("Yes") || response.equals("yes") || response.equals("y")) {
            System.out.print("What would you like the data interval to be? (seconds) ");
            interval = stdin.nextInt();
            if (interval > orbitTime) {
            	System.out.println("The interval may not be longer than the orbit time, providing\n"
            			+ "a single interval of data.");
            	interval = orbitTime;
            }
        }
        
        stdin.close();
        System.out.println();
        
        for (int x = 0; x < (orbitTime / interval); x++) {
            dibit.simulate(interval);
            dibit.simulate(x);
            System.out.println("Altitude: " + dibit.getAltitude()
                    + "\tx: " + dibit.getX()
                    + "\ty: " + dibit.getY()
                    + "\tvx: " + dibit.getVx()
                    + "\tvy: " + dibit.getVy());
            //ToDo: Need to simulate print outs every 60 seconds for time entered by user
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

