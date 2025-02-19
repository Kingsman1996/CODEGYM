public class CylinderTest {
    boolean testGetVolume0And0() {
        int radius = 0;
        int height = 0;
        double expected = 0;
        double result = Cylinder.getVolume(radius, height);
        return expected == result;
    }
    boolean testGetVolume1And2() {
        int radius = 1;
        int height = 2;
        double expected = 18.84955592153876;
        double result = Cylinder.getVolume(radius, height);
        return expected == result;
    }

    public static void main(String[] args) {
        CylinderTest test = new CylinderTest();
        System.out.println(test.testGetVolume0And0());
        System.out.println(test.testGetVolume1And2());
    }
}
