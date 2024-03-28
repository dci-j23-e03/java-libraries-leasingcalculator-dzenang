public class LeasingCar {

  private String brand;
  private String model;
  private double monthlyLeasingAmount;
  private double yearlyInsuranceCost;
  private double fuelConsumptionPer100Km;
  private double monthlyCost;

  public LeasingCar() {
  }

  public LeasingCar(String brand, String model, double monthlyLeasingAmount,
      double yearlyInsuranceCost, double fuelConsumptionPer100Km, double monthlyCost) {
    this.brand = brand;
    this.model = model;
    this.monthlyLeasingAmount = monthlyLeasingAmount;
    this.yearlyInsuranceCost = yearlyInsuranceCost;
    this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
    this.monthlyCost = monthlyCost;
  }

  public String getBrand() {
    return brand;
  }

  public LeasingCar setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  public String getModel() {
    return model;
  }

  public LeasingCar setModel(String model) {
    this.model = model;
    return this;
  }

  public double getMonthlyLeasingAmount() {
    return monthlyLeasingAmount;
  }

  public LeasingCar setMonthlyLeasingAmount(double monthlyLeasingAmount) {
    this.monthlyLeasingAmount = monthlyLeasingAmount;
    return this;
  }

  public double getYearlyInsuranceCost() {
    return yearlyInsuranceCost;
  }

  public LeasingCar setYearlyInsuranceCost(double yearlyInsuranceCost) {
    this.yearlyInsuranceCost = yearlyInsuranceCost;
    return this;
  }

  public double getFuelConsumptionPer100Km() {
    return fuelConsumptionPer100Km;
  }

  public LeasingCar setFuelConsumptionPer100Km(double fuelConsumptionPer100Km) {
    this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
    return this;
  }

  public double getMonthlyCost() {
    return monthlyCost;
  }

  public LeasingCar setMonthlyCost(double monthlyCost) {
    this.monthlyCost = monthlyCost;
    return this;
  }

  @Override
  public String toString() {
    return "LeasingCar{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", monthlyLeasingAmount=" + monthlyLeasingAmount +
        ", yearlyInsuranceCost=" + yearlyInsuranceCost +
        ", fuelConsumptionPer100Km=" + fuelConsumptionPer100Km +
        ", monthlyCost=" + monthlyCost +
        '}';
  }
}
