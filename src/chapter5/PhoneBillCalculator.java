package chapter5;

/*
Calculate the final total of someone's cell phone bill.
Allow the operator to input the plan fee and the number of overage minutes.
Charge the user 0.25 for every minute they were over their plan, and 15% tax on the subtotal.
Create separate methods to calculate the tax, overage fees, and final total.
Print the itemized bill.

Enter base cost of the plan:
82.45
Enter overage minutes:
9
Phone Bill Statement
Plan: $82.45
Overage: $2.25
Tax: $12.71
Total: $97.41
 */


import java.text.DecimalFormat;
import java.util.Scanner;

public class PhoneBillCalculator {

    static Scanner scanner = new Scanner((System.in));
    static int tax = 15;
    static double fee = 0.25;

    public static void main(String[] arg) {

        double plan = getBaseCostOfPlan();

        int overage = getOverageMinute();

        double overageCost = countOverageCost(overage);

        double tax = countTaxForAll(plan, overageCost);

        generatePhoneBill(plan, overageCost, tax);

        scanner.close();
    }


    public static double getBaseCostOfPlan(){
        System.out.println("Enter base cost of the plan: ");
        return scanner.nextDouble();
    }

    public static int getOverageMinute(){
        System.out.println("Enter overage minutes: ");
        return scanner.nextInt();
    }

    public static double countOverageCost(int overageMinutes){
        return overageMinutes * fee;
    }

    public static double countTaxForAll(double plan, double overage){
        double totalFee = (plan + overage);
        return totalFee * tax / 100;
    }

    private static void generatePhoneBill(double plan, double overageCost, double tax) {
        System.out.println("Phone Bill Statement");
        System.out.println("Plan: $" + String.format("%.2f", plan)); //nice way to format float/double - think of it as a String not as a number value - at the same time it can rounded values.
        System.out.println("Overage: " + String.format("%.2f", overageCost));
        System.out.println("Tax: " + String.format("%.2f", tax));
        double totalBill = plan + overageCost + tax;
        System.out.println("Total: " + String.format("%.2f", totalBill));
    }
}