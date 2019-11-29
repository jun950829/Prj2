import java.util.*;
import java.awt.*;

public class Road {
    public static final int DEFAULT_LENGTH = 200;
    private int length;

    private Car[] cars = null; //cars on the road
    private int numCars = 0; // number of cars on the road
    private int numCutin = 0; // number of line cutters on the road
    private int tripTime = 0; //trip time of the last car the exits
    private int tripDist = 0; // trip distance of the last car the exits
    private Random rand = new Random();


    // create a road with DEFAULT_LENGTH
    public Road() {
        cars = new Car[DEFAULT_LENGTH];
        for(int i = 0; i < DEFAULT_LENGTH; i++)
            cars[i] = null;

        toString();
    }

    // create a road with the specified length
    public Road(int length) {
        cars = new Car[length];
        for(int i = 0; i < length; i++)
            cars[i] = null;

        toString();
    }

    // Update the road
    public void update(double arrivalRate, double slowdownRate, double cutinRate) {
        for(int k = this.cars.length-1; k >= 0; k--)  //모든 차들 이동
            this.cars[k].move();
        if(cars[0] == null)
            cars[0] = new Car();
        for(int i = 0; i < this.cars.length; i++) {// 모든 차들 속도 업데이트
            for (int j = 1; j <= 5; j++)
                if (i + j <= 199 && this.cars[i + j] != null)
                    this.cars[i].setFrontCar(this.cars[i + j]);
            this.cars[i].updateSpeed(0.3);
        }



        // each car updates speed and moves
        //if a normal car exits, record its trip time and trip distance
        // a new car randomly enters if position 0 is empty
        // cut in the line
        // at most one car can cut in between two adjacent cars
    }

    // cut in randomly with the rate of cutinRate
// return a random position between rear and front if a car cuts in,
// or return -1 if no car cuts in
//    private int cutInLine(int rear, int front, double cutinRate) {
//    }

    //return the number of cars on the road
    public int getNumCars() {
        int cnt = 0;
        for(int i = 0; i < this.cars.length; i++)
            if(this.cars[i] != null)
                cnt++;
        return cnt;
    }

    //return the number of line cutters on the road
    public int getNumCutin() {
        return 0;
    }

    //return the trip time of the last car that exits
//    public int getTripTime() {}

    //return the trip distance of the last car that exits
//    public int getTripDist() {}

    // return a string representation
    public String toString() {
        String road = "";
        for(int i = 0; i <this.cars.length; i++)
            if(this.cars[i] == null)
                road += ' ';
            else
                road += this.cars[i];
        return road;
    }

//    //  draw the road
//    //  width: length * carsize , height: carsize
//    //  car color
//    //usingPhone : blue, lineCutter : red, others: gray
//    public void paint (Graphics g, int y, int carsize) {
//    }
}
