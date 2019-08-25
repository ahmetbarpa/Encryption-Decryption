package encryptdecrypt;

public class Unicode implements Algorithm {
	@Override
	public String encrypt(String data, int key) {
		char[] chars = data.toCharArray();
		
		for(int i = 0; i < chars.length; i++){
			chars[i] += key;
		}
		return String.valueOf(chars);
	}
	
	@Override
	public String decrypt(String data, int key) {
		char[] chars = data.toCharArray();
		
		for(int i = 0; i<chars.length; i++){
			chars[i] -= key;
		}
		
		return String.valueOf(chars);
	}
}
