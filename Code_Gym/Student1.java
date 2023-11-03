public class Student1 {
    private String name = "John";
    private String classes = "C02";
    Student1(){

    }
    public void setName(String name){
        this.name = name;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }

    public static void main(String[] args) {
        Student1 a = new Student1();
        a.setName("Phuong");
        a.setClasses("C09");
        System.out.println();
    }
}
