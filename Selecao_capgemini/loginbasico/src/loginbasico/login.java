package loginbasico;

import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

public class login {
	public static void main(String[] args) {
		String senha;
		String nome;
		String mensagem = "";
		Boolean senhaValida = false;
		
		Scanner leitor = new Scanner(System.in); 

		System.out.println("Digite seu nome");
		nome = leitor.next();
		
		System.out.println("Sua senha deve seguir seguinte padrão:\r\n"
				
				+"Possuir no mínimo 6 caracteres.\r\n"
				+ "Conter no mínimo 1 digito.\r\n"
				+ "Conter no mínimo 1 letra em minúsculo.\r\n"
				+ "Conter no mínimo 1 letra em maiúsculo.\r\n"
				+ "Conter no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+\r\n"
				+ "");
		
		while (!senhaValida) {
			System.out.println("Digite senha");
			senha = leitor.next();
			
			if(senha.length() < 6) {
				System.out.println("Senha muito curta");
				continue;
			}
			
			Pattern patternCaracterEspecial = Pattern.compile("[^a-zA-Z0-9]");
			Matcher matchCaracterEspecial = patternCaracterEspecial.matcher(senha);
			
			Pattern patternCaracterLetramaus = Pattern.compile("[A-Z]");
			Matcher matchCaracterLetramaus = patternCaracterLetramaus.matcher(senha);
			
			Pattern patternCaracterLetram = Pattern.compile("[a-z]");
			Matcher matchCaracterLetram = patternCaracterLetram.matcher(senha);
			
			Pattern patternCaracterNum = Pattern.compile("[0-9]");
			Matcher matchCaracterNum= patternCaracterNum.matcher(senha);
			
			
			Boolean possuiCaracterEspecial = matchCaracterEspecial.find();
			Boolean possuiCaracterLetramaus = matchCaracterLetramaus.find();
			Boolean possuiCaracterLetram = matchCaracterLetram.find();
			Boolean possuiCaractarNum = matchCaracterNum.find();
			
			senhaValida = possuiCaractarNum && possuiCaracterEspecial && possuiCaracterLetram && possuiCaracterLetramaus;
			
		    if (!possuiCaracterEspecial) {
		    	mensagem= mensagem+"Não possui caracter especial\r\n";	
		    }
		
		    if (!possuiCaracterLetramaus) {
		    	mensagem=mensagem+ "Não possui letra maiuscula\r\n";
		    }
		
		    if (!possuiCaracterLetram) {
		    	mensagem=mensagem+ "Não possui letra minuscula\r\n";
		    }
		
		    if(!possuiCaractarNum) {
		    	mensagem=mensagem+ "Não possui numero";
		    }
			       
			if(!senhaValida) {
				System.out.println("Possui o seguinte problema com sua senha:\r\n"+mensagem);
				mensagem = "";
			}else {
				System.out.println("Senha Válida");
				mensagem = "";
			}
		}
			
		leitor.close();
	
	}
}
	
