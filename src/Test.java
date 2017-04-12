public class Test {
    public static void main(String[] args) {
        DataCarrier dc = new DataCarrier(0,0,0,0,1, "First");

        assert (dc.getValue().equals("First"));

        dc.setState(1,1,1,1,1);
        dc.setValue("Second");
        assert (dc.getValue() == "Second");

        dc.setState(0,0,0,0,1);
        assert (dc.getValue() == "First");
    }
}
