public class Calculator {


    public static String operator = "add";
    public static  int add(int num1, int num2){
        return num1 + num2;
    }

    public static int divide(int num1, int num2){

        if (num1 == 0){
            throw new ArithmeticException();
        }
        return num1 / num2;
    }

}
