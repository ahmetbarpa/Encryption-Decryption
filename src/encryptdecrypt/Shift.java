package encryptdecrypt;

public class Shift implements Algorithm {
	
	@Override
	public String encrypt(String data, int key) {
		char[] charArray = data.toCharArray();
		char[] result = new char[charArray.length];
		
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i] >= 97 && charArray[i] <= 122){
				if(charArray[i] + key >= 'z'){
					result[i] = (char) (charArray[i] + key - 26);
				} else {
					result[i] = (char) (charArray[i] + key);
				}
			}
		}
		return String.valueOf(result);
	}
	
	@Override
	public String decrypt(String data, int key) {
		char[] charArray = data.toCharArray();
		char[] result = new char[charArray.length];
		
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i] >= 97 && charArray[i] <= 122){
				if(charArray[i] - key <= 'a'){
					result[i] = (char) (charArray[i] - key + 26);
				} else {
					result[i] = (char) (charArray[i] - key);
				}
			}
		}
		return String.valueOf(result);
	}
}
