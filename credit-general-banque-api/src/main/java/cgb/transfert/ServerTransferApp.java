package cgb.transfert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerTransferApp {

	public static void main(String[] args) {
		SpringApplication.run(ServerTransferApp.class, args);    	
		// TODO Auto-generated method stub	
		//Tester chargement...

		String iban = IBANGenerator.generateValidIban();
		
		System.out.println(CGBIBANValidator.isIbanStructureValide(iban));
		System.out.println(CGBIBANValidator.isIbanValide(iban));
		System.out.println(CGBIBANValidator.getCodePays(iban));
		System.out.println(CGBIBANValidator.getChiffreControle(iban));
		System.out.println(CGBIBANValidator.getBBAN(iban));
	}
}

