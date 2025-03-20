import java.util.Scanner;

public class ReadingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = sc.nextInt();
        String numberString = Integer.toString(number);
        String lastNumber = numberString.charAt(numberString.length() - 1) + "";
        String middleNumber;
        String firstNumber;
        switch (lastNumber) {
            case "0":
                lastNumber = "";
                break;
            case "1":
                lastNumber = "One";
                break;
            case "2":
                lastNumber = "Two";
                break;
            case "3":
                lastNumber = "Three";
                break;
            case "4":
                lastNumber = "Four";
                break;
            case "5":
                lastNumber = "Five";
                break;
            case "6":
                lastNumber = "Six";
                break;
            case "7":
                lastNumber = "Seven";
                break;
            case "8":
                lastNumber = "Eight";
                break;
            case "9":
                lastNumber = "Nine";
        }
        if (number == 0) {
            System.out.println("Zero");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            if (number < 10) {
                System.out.println(lastNumber);
            } else if (number == 10) {
                System.out.println("Ten");
            } else if (number < 20) {
                switch (number) {
                    case 11:
                        System.out.println("Eleven");
                        break;
                    case 12:
                        System.out.println("Twelve");
                        break;
                    case 13:
                        System.out.println("Thirteen");
                        break;
                    case 15:
                        System.out.println("Fifteen");
                        break;
                    default:
                        System.out.println(lastNumber + "teen");
                }
            } else if (number < 100) {
                middleNumber = numberString.charAt(numberString.length() - 2) + "";
                switch (middleNumber) {
                    case "2":
                        System.out.println("Twenty " + lastNumber);
                        break;
                    case "3":
                        System.out.println("Thirty " + lastNumber);
                        break;
                    case "4":
                        System.out.println("Forty " + lastNumber);
                        break;
                    case "5":
                        System.out.println("Fifty " + lastNumber);
                        break;
                    case "6":
                        System.out.println("Sixty " + lastNumber);
                        break;
                    case "7":
                        System.out.println("Seventy " + lastNumber);
                        break;
                    case "8":
                        System.out.println("Eighty " + lastNumber);
                        break;
                    case "9":
                        System.out.println("Ninety " + lastNumber);
                }
            } else if (number < 1000) {
                firstNumber = numberString.charAt(numberString.length() - 3) + "";
                middleNumber = numberString.charAt(numberString.length() - 2) + "";
                switch (firstNumber) {
                    case "1":
                        firstNumber = "One";
                        break;
                    case "2":
                        firstNumber = "Two";
                        break;
                    case "3":
                        firstNumber = "Three";
                        break;
                    case "4":
                        firstNumber = "Four";
                        break;
                    case "5":
                        firstNumber = "Five";
                        break;
                    case "6":
                        firstNumber = "Six";
                        break;
                    case "7":
                        firstNumber = "Seven";
                        break;
                    case "8":
                        firstNumber = "Eight";
                        break;
                    case "9":
                        firstNumber = "Nine";
                        break;
                }
                switch (middleNumber) {
                    case "0":
                        switch (lastNumber) {
                            case "0":
                                System.out.println(firstNumber + " hundred");
                                break;
                            default:
                                System.out.println(firstNumber + " hundred" + " and " + lastNumber);
                        }
                        break;
                    case "1":
                        switch (lastNumber) {
                            case "0":
                                System.out.println(firstNumber + " hundred " + "and ten");
                                break;
                            case "1":
                                System.out.println(firstNumber + " hundred " + "and eleven");
                                break;
                            case "2":
                                System.out.println(firstNumber + " hundred " + "and twelve");
                                break;
                            case "3":
                                System.out.println(firstNumber + " hundred " + "and thirteen");
                                break;
                            case "5":
                                System.out.println(firstNumber + " hundred " + "and fifteen");
                                break;
                            default:
                                System.out.println(firstNumber + " hundred " + "and" + lastNumber + "teen");
                        }
                        break;
                    case "2":
                        System.out.println(firstNumber + " hundred " + "and Twenty " + lastNumber);
                        break;
                    case "3":
                        System.out.println(firstNumber + " hundred " + "and Thirty " + lastNumber);
                        break;
                    case "4":
                        System.out.println(firstNumber + " hundred " + "and Fourty " + lastNumber);
                        break;
                    case "5":
                        System.out.println(firstNumber + " hundred " + "and Fifty " + lastNumber);
                        break;
                    case "6":
                        System.out.println(firstNumber + " hundred " + "and Sixty " + lastNumber);
                        break;
                    case "7":
                        System.out.println(firstNumber + " hundred " + "and Seventy " + lastNumber);
                        break;
                    case "8":
                        System.out.println(firstNumber + " hundred " + "and Eighty " + lastNumber);
                        break;
                    case "9":
                        System.out.println(firstNumber + " hundred " + "and Ninety " + lastNumber);
                }
            } else {
                System.out.println("Out of range");
            }
        }
    }
}
