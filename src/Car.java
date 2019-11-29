import javax.swing.*;

public class Car {
    public static final int MAXSPEED = 5;
    private static int lastId = 0;
    private int id ;// unique id

    private int speed ;// speed
    private int time ;// trip time
    private int position ;// position
    private int distance ;// trip distance

    private Car frontCar = null;

    private boolean usingPhone;
    private boolean lineCutter;

    // create a car at 0
    public Car() {
        id = ++lastId;  //자동차의 넘버 자동 부여
        speed = (int)(Math.random()*5);  //0~4 까지 기본 속도랜덤 부여
        position = 0; //이 차의 위치
        time = 0; // 이 차의 trip time
        distance = 0; //이 차의 이동거리

        toString();

    }

    //create a car at the specified position
    //this car is a lineCutter
    public Car(int at) {
        id = ++lastId;  //자동차의 넘버 자동 부여
        speed = (int)(Math.random()*5);  //0~4 까지 기본 속도랜덤 부여
        position = at-1; //이차의 위치
//        isLineCutter() = true;

        toString();

    }

    //update the speed (0 5)                   55
    //increase the speed by one if speed < 5                   55
    //if the front car is d away, then reduce the speed to d 1              55
    //a car randomly slows down by 1
    //     usingPhone = true, speed > 1
    public void updateSpeed(double slowdownRate) {
        if(this != null) {
            if (this.speed >= 5) //속도가 5이상이면 5로 고정 , 아니면 +1
                speed = 5;
            else
                speed += 1;
            if(this.frontCar != null) {
                int d = this.frontCar.getPos() - this.getPos();  //앞차와의 거리 pos 반환
                if (d <= speed)   //speed가 d보다 크다면 speed를 d-1로 반환
                    speed = d - 1;
            }
        }
    }

    //move the car
    public void move() {
        if(this != null) {      //빈 객체가 아니라면 이 객체의 스피드만큼 이동, 빈 객체면 통과
            this.position = this.position + this.speed;
            getTime(); //한번 움직였으니 1초추가
        }
        else
            return;

    }

    //return the position
    public int getPos() {          //현재 이 객체의 포지션값 리턴
        return this.position;
    }

    //return the trip time
    public int getTime() {    //move 할때마다 1초 추가
        return this.time +=1;
    }

    //return the trip distance
//    public int getDist() {}

    //set the front car
    public void setFrontCar(Car car) { //this의 frontCar 는 Car
        this.frontCar = car;
    }

//    //return true if this car is a linecutter
//    public boolean isLineCutter() {}
//
//    //return true if this car is using phone
//    public boolean usingPhone() {}

    //return string representation
    //lineCutter : X, others: id%10
    public String toString() {
        String name = "" + id%10;
        return name;
    }

}