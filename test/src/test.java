class test {
    final int x = 5;

    test(int value) {
        x = value;
    }

    void printValue() {
        System.out.println("The value of x: " + x);
    }

    public static void main(String[] args) {
        test myObj = new test(10);
        myObj.printValue();
        new test(5).printValue();
    }
}