import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class Exercise {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int monthlyDistance = getDistanceFromUser(scanner);
    int insuranceDiscountPercent = getInsuranceDiscountFromUser(scanner);

    // Read the Excel file into a List of LeasingCar Objects
    List<LeasingCar> leasingCarList = readLeasingCars("LeasingCars.xls");

    // Calculate the total cost for each car (and find the least expensive option)
    calculateCosts(leasingCarList, monthlyDistance, insuranceDiscountPercent);
    LeasingCar bestOffer = findBestOffer(leasingCarList);

    Formatter formatter = new Formatter();

    System.out.println("\nThe " + bestOffer.getBrand() + " " + bestOffer.getModel()
        + " is the best offer with a total cost of "
        + formatter.format("%.2f", bestOffer.getMonthlyCost()));
  }

  private static List<LeasingCar> readLeasingCars(String fileName) throws IOException {
    // TODO: add your code here
  }

  private static void calculateCosts(List<LeasingCar> leasingCarList, int monthlyDistance,
      int insuranceDiscountPercent) {
    // TODO: add your code here
  }

  private static LeasingCar findBestOffer(List<LeasingCar> leasingCarList) {
    // TODO: add your code here
  }

  private static int getDistanceFromUser(Scanner scanner) {
    System.out.println("Please enter the amount of kilometers you drive monthly (no decimals):");
    return scanner.nextInt();
  }

  private static int getInsuranceDiscountFromUser(Scanner scanner) {
    System.out.println("Please enter the percent-discount for your insurance plan:");
    return scanner.nextInt();
  }


}
