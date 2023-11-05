public class TriangleClassifier {
    int a, b, c;
    TriangleClassifier(int a, int b, int c){
        this. a = a;
        this.b = b;
        this.c = c;
    }
    public String getKindOfTriangle(){
        if(a == b && a == c) return "Tam giac deu";
        else if(a == b && a != c) return "Tam giac can";
        else if(a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) return "Tam giac thuong";
        else return "Khong phai la tam giac";
    }
}
