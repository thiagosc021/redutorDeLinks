package redutordelinks

class LinkShorterService {

    static transactional = false
	
	//Caracteres base para conversao do link [a-zA-Z0-9] 62 caracteres
	static String tab="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789"

    /**
	 * Methodo responsavel pelo encurtamento do link
	 * o mesmo usa o id que e um campo de auto incremento do mysql como base para o link reduzido
	 * a ideia e converter o id que esta na base 10 para uma nova base onde os digitos sao letras [a-zA-Z] e numeros de [0-9]
	 * @return novo link encurtado
	 */
	String shortLink(BigInteger idLink) {
		def reduced=""
		def digits=[]
		//efetuando a mudanca de base idlink esta na base 10 a ideia e passar para base 62
		while(idLink>0){
			int reminder=idLink%62;
			digits.push(reminder);6
			idLink=idLink.intdiv(62);
		}
		
		def reversedDigits = digits.reverse()
		
		//encontrando os carecteres respectivos para cada digito
		reversedDigits.each { d ->
			reduced = reduced + tab.charAt(d);
		}
		return reduced
	}
	
	/**
	 * Metodo responsavel pela conversao do link reduzido
	 * @param reducedLink 
	 * @return link completo
	 */
	Link loadLink(String reducedLink){
		int p = reducedLink.length() -1
		BigInteger id=0

		//convertendo link que esta na base 62 para um numero inteiro na base 10
		reducedLink.each{
			def index= tab.indexOf(it)
			id = id + index*62**p
			p--
		}

		//o numero inteiro corresponde ao id do link no banco de dados
		def linkInstance = Link.get(id)
		
		return linkInstance
	}
}
