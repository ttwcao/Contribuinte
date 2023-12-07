package entities;

//esta classe herda tudo que possui na Classe TaxPayer
//esta classe deve implementar  

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;

	
	public Individual() {
	}
	
	
	//este construtor é geredo utilizando os atributos herdados
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		
		//usando atributo da classe .this e não argumento do método
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}


	//sobreescrever para implementação tax
	@Override
	public double tax() {
		double basicTax;
		if (getAnualIncome()< 20000.0 ) {
			basicTax = getAnualIncome() * 0.15;
		}
		else {
			basicTax = getAnualIncome() * 0.25;
		}
		
		basicTax = basicTax - getHealthExpenditures() * 0.5;
		
		if(basicTax < 0.0) {
			return 0;
		}else {
			return basicTax;
		}
		
	}

}
