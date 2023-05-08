import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
            static int[] accountNumbers = {404301, 404302, 404303, 404304};
            static int[] pin = {4301, 4302, 4303, 4304};
            static double[] money /* IN Rupees */ = {15000, 10000, 4000, 65000};
            static ArrayList <String> transactionHist = new ArrayList<String>();



    public static void AtmMachine() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Welcome to SSM Bank!\nPlease Enter your account number:");
            int AccNum = sc.nextInt();
            System.out.print("Pin:");
            int AccPin = sc.nextInt();

            int a = accountNumbers.length+1;
            for (int i = 0; i < accountNumbers.length; i++){
                if (accountNumbers[i] == AccNum && pin[i] == AccPin ){
                    System.out.println("Welcome " + accountNumbers[i] + "!");
                    a = i;
                    System.out.println("Your Account Balance is Rs. " + money[a]);
                    break;
                }
            } 
            if (a == accountNumbers.length+1){
                System.out.println("INVALID Account Number OR PIN!!\nLogin Again:-\n");
                AtmMachine();
            }
            while (true) {
            System.out.println("What do you want to do?\nPress Below Options to do as per given instructions.");
            System.out.println("Press 1: Withdraw");
            System.out.println("Press 2: Deposit");
            System.out.println("Press 3: Transfer");
            System.out.println("Press 4: Transactions History");
            System.out.println("Press 5: Quit");

            int option = sc.nextInt();

                switch (option) {


                    case 1:
                    System.out.println("Enter Amount To Withdraw:");
                    Double amount1;
                    amount1 = sc.nextDouble();
                    if (amount1 > money[a]){
                        System.out.println("Insufficient Balance in Account!!");
                    } else {
                        money[a] -= amount1;
                        String x = ("You have Withdrawn " + amount1 + " from your account number " + accountNumbers[a] + ".");
                        System.out.println(x + "\nYour account balance is " + money[a]);
                        transactionHist.add(x);
                    }
                    System.out.println();
                    break;


                    case 2:
                    System.out.println("Enter Amount To Deposit:");
                    Double amount2;
                    amount2 = sc.nextDouble();
                        money[a] += amount2;
                        String y = ("You have deposited " + amount2 + " to your account number " + accountNumbers[a] + ".");
                        System.out.println(y + "\nYour account balance is " + money[a]);
                        transactionHist.add(y);
                        System.out.println();
                    break;


                    case 3:
                    System.out.println("Enter the account number of the benificiary:");
                    int benificiary;
                    benificiary = sc.nextInt();
                    int b;
                    for (int i=0; i<=accountNumbers.length; i++) {
                        if (benificiary == accountNumbers[i]) {
                            if (benificiary != accountNumbers[a]) {
                                b = i;
                                System.out.println("Enter the amount to transfer:");
                                Double Amount3;
                                Amount3 = sc.nextDouble();
                                    if (Amount3 <= money[a]) {
                                        money[b] += Amount3;
                                        money[a] -= Amount3;
                                    } else {
                                        System.out.println("You do not have enough funds to transfer this amount.");
                                        System.out.println("Your Account Balance is " + money[a]);
                                        break;
                                    }
                                String z = ("The amount " + Amount3 + " is transferred to the account number " + benificiary + ".");
                                System.out.println(z + "\nYour Account Balance is Rs. " + money[a]);
                                System.out.println();
                                transactionHist.add(z);
                                break;
                            } else {
                                System.out.println("You can not tranfer amount to your same Account Number!");
                                System.out.println();
                                break;
                            }
                        }
                    }
                    System.out.println();
                    break;

                    case 4:
                    System.out.println("Transaction history:");
                    for (String transaction : transactionHist) {
                        System.out.println(transaction);
                    }
                    System.out.println();
                    break;


                    case 5:
                    System.out.println("Thank You For Banking with SSM Bank!!\nLogging Out!!!");
                    return;

                    default:
                    System.out.println("Invalid Input!!\nAuto Logging Out!!!\nLogin Again:-");
                    System.out.println();
                    AtmMachine();
            }
        }
    }
}
        public static void main(String args[]) {
        AtmMachine();
    }
} 