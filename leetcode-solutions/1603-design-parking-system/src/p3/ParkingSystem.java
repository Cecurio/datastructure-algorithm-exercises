package p3;

/**
 * @author shanxiaokai
 * @date 2021/3/19 10:45
 */
public class ParkingSystem {

    int[] car = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        car[1] = big;
        car[2] = medium;
        car[3] = small;
    }

    public boolean addCar(int carType) {
        return car[carType] != 0 && car[carType]-- > 0;
    }

}
