import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Exercise {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int monthlyDistance = getDistanceFromUser(scanner);
    int insuranceDiscountPercent = getInsuranceDiscountFromUser(scanner);

    // Read the Excel file into a List of LeasingCar Objects
    List<LeasingCar> leasingCarList = readLeasingCars("LeasingCars.xls");
//    for (LeasingCar car : leasingCarList) {
//      System.out.println(car);
//    }

    // Calculate the total cost for each car (and find the least expensive option)
    calculateCosts(leasingCarList, monthlyDistance, insuranceDiscountPercent);
    LeasingCar bestOffer = findBestOffer(leasingCarList);

    Formatter formatter = new Formatter();

    System.out.println("\nThe " + bestOffer.getBrand() + " " + bestOffer.getModel()
        + " is the best offer with a total cost of "
        + formatter.format("%.2f", bestOffer.getMonthlyCost()));
  }

  private static List<LeasingCar> readLeasingCars(String fileName) throws IOException {
    FileInputStream inputStream = new FileInputStream("src/main/resources/" + fileName);

    List<LeasingCar> carList = new ArrayList<>();
    Workbook workbook = new HSSFWorkbook(inputStream);
    Sheet sheet = workbook.getSheetAt(0);

    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);

      LeasingCar car = new LeasingCar();
      car.setBrand(row.getCell(0).getStringCellValue());
      car.setModel(row.getCell(1).getStringCellValue());
      car.setMonthlyLeasingAmount(row.getCell(2).getNumericCellValue());
      car.setYearlyInsuranceCost(row.getCell(3).getNumericCellValue());
      car.setFuelConsumptionPer100Km(row.getCell(4).getNumericCellValue());

      carList.add(car);
    }
    return carList;
  }

  private static void calculateCosts(List<LeasingCar> leasingCarList, int monthlyDistance,
      int insuranceDiscountPercent) {
    for (LeasingCar car : leasingCarList) {
      calcualteCost(car, monthlyDistance, insuranceDiscountPercent);
    }
  }

  // 17%
  private static void calcualteCost(LeasingCar car, int monthlyDistance, int insuranceDiscountPercent) {
    double monthlyCost = car.getMonthlyLeasingAmount();
    double insuranceFactor = (((double)(100 - insuranceDiscountPercent)) / 100);
    double monthlyInsuranceCost = (insuranceFactor * car.getYearlyInsuranceCost()) / 12;
    double fuelConsumption = (monthlyDistance / 100) * car.getFuelConsumptionPer100Km();

    monthlyCost = monthlyCost + monthlyInsuranceCost + fuelConsumption;
    car.setMonthlyCost(monthlyCost);
    // Monthly cost for the BMW 8er is 494.83
    System.out.printf("Montly cost for the %s %s is %.2f%n", car.getBrand(), car.getModel(), car.getMonthlyCost());
  }

  private static LeasingCar findBestOffer(List<LeasingCar> leasingCarList) {
    LeasingCar bestOffer = leasingCarList.get(0);

    for (LeasingCar car : leasingCarList) {
      if (car.getMonthlyCost() < bestOffer.getMonthlyCost()) {
        bestOffer = car;
      }
    }
    return bestOffer;
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
