class main{
    public static void main(String[] args) {
        testcon a = new testcon();
        testcha b = (testcha) a;
        if(b instanceof testcha) System.out.println("yes");

    }
}