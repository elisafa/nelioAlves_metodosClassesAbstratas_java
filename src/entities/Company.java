package entities;

public class Company extends TaxPayer{
	
	private Integer numberOfEmployess;
	
	public Company () {}

	public Company(String name, Double anualIncome, Integer numberOfEmployess) {
		super(name, anualIncome);
		this.numberOfEmployess = numberOfEmployess;
	}

	public Integer getNumberOfEmployess() {
		return numberOfEmployess;
	}

	public void setNumberOfEmployess(Integer numberOfEmployess) {
		this.numberOfEmployess = numberOfEmployess;
	}

	@Override
	public double tax() {
		double employee = (numberOfEmployess > 10) ? (getAnualIncome() * 0.14) : (getAnualIncome() * 0.16);
		return employee;
	}
	
	

}
