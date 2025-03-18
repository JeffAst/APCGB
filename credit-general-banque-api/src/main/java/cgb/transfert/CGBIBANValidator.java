package cgb.transfert;
import org.apache.commons.validator.routines.IBANValidator;
public class CGBIBANValidator {
	
private static CGBIBANValidator instance;
   private static IBANValidator ibanValidator = IBANValidator.getInstance();
	
	private CGBIBANValidator() {}
	
	public static CGBIBANValidator getInstanceValidator() {
		if (instance == null) {
			instance = new CGBIBANValidator();
		}
		return instance;
	}
	
	
	public static boolean isIbanStructureValide(String iban) {
		 return iban != null && iban.matches("^[A-Z]{2}\\d{2}[A-Z0-9]{11,30}$");
	}
	
	public static boolean isIbanValide(String iban) {
		return ibanValidator.isValid(iban);
	}
	
	public static String getCodePays(String iban) {
       if (isIbanValide(iban)) {
           return iban.substring(0, 2);
       }
       return "Code du pays non valide";
   }
	
	public static String getChiffreControle(String iban) {
       if (isIbanValide(iban)) {
           return iban.substring(2, 4);
       }
       return "Chiffres de contrôle non valide";
   }
	
	public static String getBBAN(String iban) {
       if (isIbanValide(iban)) {
           return iban.substring(4);
       }
       return "BBAN non valide";
   }
}