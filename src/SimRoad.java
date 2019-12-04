public class SimRoad {
    public static void main(String[] args) {
        Road road = new Road();

        double arrivalRate = 1.0;
        double slowdownRate = 0.0;
        double cutinRate = 0.1;

        for(int n = 0; n < 100; n++) {
            road.update(arrivalRate, slowdownRate, cutinRate);
                System.out.format("%3d: (%2d, %2d) %s%n", n, road.getNumCars(), road.getNumCutin(), road);
        }
    }
}
