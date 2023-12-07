package entities;

public class Company extends TaxPayer{
	
	private Integer numberOfEmployes;
	
	public Company() {
	}
	
	//este construtor é geredo utilizando os atributos herdados
	public Company(String name, Double anualIncome, Integer numeberOfEmployes) {
		super(name, anualIncome);
		
		//usando atributo da classe .this e não argumento do método
		this.numberOfEmployes = numeberOfEmployes;
	}

	public Integer getNumeberOfEmployes() {
		return numberOfEmployes;
	}

	public void setNumeberOfEmployes(Integer numeberOfEmployes) {
		this.numberOfEmployes = numeberOfEmployes;
	}

	//sobreescrever para implementação tax
	@Override
	public double tax() {
		if(getNumeberOfEmployes() > 10) {
			return getAnualIncome()* 0.14;
		} else {
			return getAnualIncome()* 0.16;
		}
	}
	
	

}
