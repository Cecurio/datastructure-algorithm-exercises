package p2;

/**
 * @author shanxiaokai
 * @date 2021/3/19 10:41
 */
public class ParkingSystem {

    int counts;

    public ParkingSystem(int big, int medium, int small) {
        counts = (small << 20) | (medium << 10) | big;
    }

    public boolean addCar(int carType) {
        int bit = ((carType - 1) * 10);
        if (((counts >> bit) & 0b1111111111) <= 0) {
            return false;
        } else {
            counts -= 1 << bit;
            return true;
        }
    }

}
