package encryptdecrypt;

class Context {
	private Algorithm algorithm;
	
	Context(Algorithm algorithm){
		this.algorithm = algorithm;
	}
	
	/** It performs the enc/dec algorithm according to the given mode
	 */
	String operation(String mode, String data, int key){
		String result;
		
		if(mode.equals("dec")){
			result = algorithm.decrypt(data, key);
		} else {
			result = algorithm.encrypt(data, key);
		}
		
		return result;
	}
}
