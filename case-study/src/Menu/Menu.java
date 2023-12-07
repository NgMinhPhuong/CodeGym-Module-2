package Menu;

import Model.User;

public class Menu {
    private static Menu instance;
    private Menu(){

    }

    public static Menu getInstance() {
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }

    public void displayMenuClient(User user){
        String defaultColor = "\u001B[0m";
        String yellowColor = "\u001B[34m";
        System.out.println("                                          " + yellowColor + "Welcome "  + user.getAccountName() + "(Client)" + defaultColor);
        System.out.println("1: Add a Product To Basket");
        System.out.println("2: Remove a Product To Basket");
        System.out.println("3: Show my Basket");
        System.out.println("4. Choose Method to Add Monney to Account");
        System.out.println("5. Add Monney to Account");
        System.out.println("6. Choose Method Payment");
        System.out.println("7. Buy Product");
        System.out.println("8. Find Product");
        System.out.println("9. Connect To Another User");
        System.out.println("10. Send A Message");
        System.out.println("11. Read MailBox");
        System.out.println("12. Check Your Account");
        System.out.println("13. Check your BankCard");
        System.out.println("14. Vote A Product");
        System.out.println("15. Show Vote About Product");
        System.out.println("16. Show Transaction History");
        System.out.println("17. Update Personal Information");
        System.out.println("18. Change Password");
        System.out.println("19. Show My Voucher");
        System.out.println("0. Log out");
        System.out.print("Enter your choose: ");
    }


    public void displayMenuShop(User user){
        String defaultColor = "\u001B[0m";
        String yellowColor = "\u001B[34m";
        System.out.println("                                          " + yellowColor + "Welcome "  + user.getAccountName() + "(Shop)" + defaultColor);
        System.out.println("1: Add a Product To Basket");
        System.out.println("2: Remove a Product To Basket");
        System.out.println("3: Show my Basket");
        System.out.println("4. Add a Product into My Store");
        System.out.println("5. Remove a Product from My Store");
        System.out.println("6. Show Product in my Store");
        System.out.println("7. Choose Method to Add Monney to Account");
        System.out.println("8. Add Monney to Account");
        System.out.println("9. Choose Method Payment");
        System.out.println("10. Buy Product");
        System.out.println("11. Find Product");
        System.out.println("12. Connect To Another User");
        System.out.println("13. Send A Message");
        System.out.println("14. Read MailBox");
        System.out.println("15. Check Your Account");
        System.out.println("16. Check your BankCard");
        System.out.println("17. Vote A Product");
        System.out.println("18. Show Vote About Product");
        System.out.println("19. Show The  revenue of My Shop");
        System.out.println("20. Show Transaction History");
        System.out.println("21. Update Personal Information");
        System.out.println("22. Change Password");
        System.out.println("23. Show My Voucher");
        System.out.println("0. Log out");
        System.out.print("Enter your choose: ");
    }


    public void displayMenuRegister_Login(){
        System.out.println("1. Resigter an account");
        System.out.println("2. Login");
        System.out.println("3. Forgot Password");
        System.out.println("0. Exit");
        System.out.print("Enter your choose: ");
    }
}
//    Màu đen: \u001B[30m
//
//        Màu đỏ: \u001B[31m
//
//        Màu xanh lá cây: \u001B[32m
//
//        Màu vàng: \u001B[33m
//
//        Màu xanh da trời: \u001B[34m
//
//        Màu tím: \u001B[35m
//
//        Màu xanh dương: \u001B[36m
//
//        Màu trắng: \u001B[37m
//
//        Màu nền đen: \u001B[40m
//
//        Màu nền đỏ: \u001B[41m
//
//        Màu nền xanh lá cây: \u001B[42m
//
//        Màu nền vàng: \u001B[43m
//
//        Màu nền xanh da trời: \u001B[44m
//
//        Màu nền tím: \u001B[45m
//
//        Màu nền xanh dương: \u001B[46m
//
//        Màu nền trắng: \u001B[47m
//
//        Chữ đậm: \u001B[1m
//
//        Chữ nghiêng: \u001B[3m
//
//        Chữ gạch chân: \u001B[4m
//
//        Chữ gạch ngang: \u001B[9m
//
//        Trở lại màu chữ mặc định: \u001B[0m

