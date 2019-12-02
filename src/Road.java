import java.util.*;
import java.awt.*;

public class Road {
    public static final int DEFAULT_LENGTH = 200;
    private int length;

    private Car[] cars = null; //cars on the road
    private int numCars = 0; // number of cars on the road
    private int numCutin = 0; // number of line cutters on the road
    private int tripTime = 0; // trip time of the last car the exits
    private int tripDist = 0; // trip distance of the last car the exits
    private Random rand = new Random();


    // create a road with DEFAULT_LENGTH
    public Road() {
        cars = new Car[DEFAULT_LENGTH];
        for (int i = 0; i < DEFAULT_LENGTH; i++)
            cars[i] = null;

        toString();
    }

    // create a road with the specified length
    public Road(int length) {
        cars = new Car[length];
        for (int i = 0; i < length; i++)
            cars[i] = null;
        toString();
    }

    public void moveCars() {
        for (int k = this.cars.length - 1; k >= 0; k--) { //모든 차들 이동
            if (this.cars[k] != null) {
                this.cars[k].move();
                if (this.cars[k].getPos() >= DEFAULT_LENGTH) {
                    tripTime = cars[k].getTime();
                    tripDist = cars[k].getDist();
                    this.cars[k] = null;

                } else {
                    if (this.cars[k].getPos() != k) {
                        this.cars[this.cars[k].getPos()] = this.cars[k];
                        this.cars[k] = null;
                    }
                }
            }
        }
    }

    public void updateSpeed(double slowDownRate) {

        for (int i = 0; i < this.cars.length; i++) {// 모든 차들 속도 업데이트
            if (this.cars[i] != null) {
                for (int j = 1; j <= 5; j++)
                    if (i + j <= 199 && this.cars[i + j] != null) {
                        this.cars[i].setFrontCar(this.cars[i + j]);
                        break;
                    }
                this.cars[i].updateSpeed(slowDownRate);
            }
        }

    }

    // Update the road
    public void update(double arrivalRate, double slowdownRate, double cutinRate) {
        int rand_car = 0;
        int rear = 0;
        int front = 0;
        updateSpeed(slowdownRate);
        moveCars();


        if (cars[0] == null && arrivalRate >= (Math.random()))
            cars[0] = new Car();

        while ( front - rear > 1) {
        rear = rand.nextInt(198);

            for (int l = rear + 1; l <= 199; l++) {
                if (cars[l] != null) {
                    l = front;
                    break;
                }
            }
        }

        rand_car = cutInLine(rear, front, cutinRate);
        if(rand_car != -1)
         cars[rand_car] = new Car(rand_car);

//        else if (cutinRate >= (Math.random())) {
//            int last_car = 0;
//            for (int k = this.cars.length - 1; k >= 0; k--) {
//                if (this.cars[k] != null) {
//                    last_car = k;
//                    break;
//                }
//            }
//            getRandomCar(last_car);
//        }



        // each car updates speed and moves
        //if a normal car exits, record its trip time and trip distance
        // a new car randomly enters if position 0 is empty
        // cut in the line
        // at most one car can cut in between two adjacent cars
    }

    // cut in randomly with the rate of cutinRate
// return a random position between rear and front if a car cuts in,
// or return -1 if no car cuts in
    private int cutInLine(int rear, int front, double cutinRate) {
        if ((cutinRate >= (Math.random()))) {
            int rand_car = (int) (Math.random() * (front - rear + 1)) + rear;
            return rand_car;
        } else
            return -1;
    }


    public void getRandomCar(int bound) {
        int random_idx = rand.nextInt(bound);
        if (cars[random_idx] == null) {
            cars[random_idx] = new Car(random_idx);
        } else {
            getRandomCar(bound);
        }
    }

    //return the number of cars on the road
    public int getNumCars() {
        int cnt = 0;
        for (int i = 0; i < this.cars.length; i++)
            if (this.cars[i] != null)
                cnt++;
        return cnt;
    }

    //return the number of line cutters on the road
    public int getNumCutin() {
        int cnt2 = 0;
        for (int i = 0; i < this.cars.length; i++)
            if (this.cars[i] != null && this.cars[i].isLineCutter())
                cnt2++;
        return cnt2;
    }

    //return the trip time of the last car that exits
    public int getTripTime() {
        return tripTime;
    }

    //return the trip distance of the last car that exits
    public int getTripDist() {
        return tripDist;
    }

    // return a string representation
    public String toString() {
        String road = "";
        for (int i = 0; i < this.cars.length; i++)
            if (this.cars[i] == null)
                road += ' ';
            else
                road += this.cars[i];
        return road;
    }

//    //  draw the road
//    //  width: length * carsize , height: carsize
//    //  car color
//    //usingPhone : blue, lineCutter : red, others: gray
    public void paint (Graphics g, int y, int carsize) {
        g.drawRect(50, 50, length * carsize, carsize);
        g.setColor(Color.gray);
        g.fillRect(50, 50, length * carsize, carsize);

    }
}
