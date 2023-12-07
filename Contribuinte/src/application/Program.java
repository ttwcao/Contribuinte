package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o número de contribuíntes: ");
		int N = sc.nextInt();
		
		/*criação da lista
		*upcasting, variável do tipo mais genérico aceita variáveis mais específicas
		*relações UML do tipo é um, permitem este tipo de aplicação
		*cada linha da lista vai chamar tax e será executado conforme o objeto instanciado j ou f
		*podendo ser 
		*/
		
		List<TaxPayer> list = new ArrayList<TaxPayer>();
		
		for (int i=1; i<=N; i++) {
			
			//cabeçalho de tela
			System.out.println("Pagador #" + i + "dados: ");
			System.out.println("Pessoa Jurídica ou Física (j/f): ");
			
			//capturar o primeiro caracter digitado
			char type = sc.next().charAt(0);
			
			//obter o nome
			System.out.println("Nome: ");
			String name = sc.next();
			
			//obter a renda
			System.out.println("Renda Anual: ");
			Double anualIncome = sc.nextDouble();
			
			//verificar qual tipo de pagador
			if(type == 'f') {
				System.out.println("Gastos com saúde: ");
				double healthExpenditures = sc.nextDouble();
				
				//instanciar Individual
				Individual dados = new Individual(name, anualIncome, healthExpenditures);
				
				//adicionar dados na lista
				list.add(dados);
			} else {
				System.out.println("Numero de funcionarios: ");
				Integer numberOfEmployes = sc.nextInt();
				
				//instanciar Company
				Company dados = new Company(name, anualIncome, numberOfEmployes);
				
				//adicionar dados na lista
				list.add(dados);
			}
			
		}
		
		System.out.println();
		System.out.println("Taxas pagas: ");		
		
		//buscar os dados na lista para exibição
		for(TaxPayer tp : list) {
			
			/*aqui temos o exemplo de polimorfismo na prática, o compilador não sabe quem é o tipo do elemento na lista 
			 * isso é determinado em tempo de execução, dependendo do tipo de objeto a ser instaciado
			 * TaxPayes é uma classe abstrata, não há implementação dela
			 **/
			System.out.println(tp.getName() + ": R$ " + String.format("%.2f", tp.tax()));
		}
		
		double sum = 0.0;
		for(TaxPayer tp : list) {
			//somatório dos valores
			sum += tp.tax();
		}
		
		System.out.println("Total de taxas: R$ " + String.format("%.2f", sum));
		
		
		
		sc.close();
		
	}

}
