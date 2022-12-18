import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        int num1;
        int num2;
        int num3;
        char operator;
        Scanner scanner = new Scanner(System.in);
        System.out.println("KATA Academy, введите первое число");
        num1 = scanner.nextInt();
        System.out.println("KATA Academy, введите второе число");
        num2 = scanner.nextInt();
        System.out.println("KATA Academy, введите оператор (+,-,*,/)");
        operator = scanner.next().charAt(0);
        switch (operator) {
            case '+': num3= num1 + num2;
                break;
            case '-': num3= num1 - num2;
                break;
            case '*': num3= num1 * num2;
                break;
            case '/': num3= num1 / num2;
                break;
            default: System.out.println("Вы ввели некорректный оператор, введите: +,-,*,/");
                return;
        }
        System.out.println("Ответ по вашему запросу равен"+ " " +num3);






}

}
