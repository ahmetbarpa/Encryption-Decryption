package encryptdecrypt;

public class Deneme implements Algorithm {
	@Override
	public String encrypt(String data, int key) {
		char[] chars = data.toCharArray();
		StringBuilder result = new StringBuilder();
		for(char ch : chars){
			ch += key;
			String hex = String.format("\\u%04x", (int) ch);
			result.append(hex);
		}
		
		return String.valueOf(result);
	}
	
	@Override
	public String decrypt(String data, int key) {
		char[] chars = data.toCharArray();
		StringBuilder result = new StringBuilder();
		
		for(char ch : chars){
			ch -= key;
			result.append(ch);
		}
		
		return String.valueOf(result);
	}
}