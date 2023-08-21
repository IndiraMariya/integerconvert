
// TODO: Auto-generated Javadoc
/**
 * The Class IntegerConverter. This class provides static methods for converting
 * integer, binary and hex strings to specified numeric primitives (int, byte)
 */
public class IntegerConvert {

	/**
	 * Instantiates a new integer converter.
	 */
	public IntegerConvert() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Convert string of decimal numbers to an int.
	 *
	 * @param in the String to convert
	 * @return the converted value of the string represented as an int
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseInt(String in) throws NumberFormatException {
		int val = 0;
		int weight = 1;
		String str = in;
		
		if (in.charAt(0) == '+' || in.charAt(0) == '-') str = in.substring(1);
		for(int i = 0; i < str.length();i++) {
			if (str.charAt(str.length()-1-i) == '_' || str.charAt(str.length()-1-i) == ' ') continue;
			int digit = str.charAt(str.length()-1-i) - '0';
			val += digit * weight;
			weight = weight * 10;
		}
		
		if (in.charAt(0) == '-') return (val * (-1));
		return (val);
	}

	/**
	 * Converts string of decimal numbers to a byte.
	 *
	 * @param in the String to convert
	 * @return the byte
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseByte(String in) throws NumberFormatException {
		byte val = 0;
		int weight = 1;
		String str = in;
		
		if (in.charAt(0) == '+' || in.charAt(0) == '-') str = in.substring(1);
		
		for(int i = 0; i < str.length();i++) {
			if (str.charAt(str.length()-1-i) == '_' || str.charAt(str.length()-1-i) == ' ') continue;
			int digit = str.charAt(str.length()-1-i) - '0';
			val += (byte)(digit * weight);
			weight = weight * 10;
		}
		
		if (in.charAt(0) == '-') return (byte)(val * (-1));
		return (val);
	}

	/**
	 * Parses an unsigned binary string and returns the equivalent integer value (signed)
	 *
	 * @param in   the input binary string. Should have a leading "0b"
	 * @return  the integer value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseBinStrToInt(String in) throws NumberFormatException {
		int val = 0;
		int digit = 0;
		int weight = 1;
		in = in.substring(2);

		for (int i = in.length()-1; i >= 0; i--) {
			if (in.charAt(i) == '_' || in.charAt(i) == ' ') continue;
			digit = in.charAt(i) - '0';
			val += digit * weight;
			weight = weight * 2;
		}
		return val;
 	}
	
	
	
	/**
	 * Parses an unsigned binary string and returns the equivalent byte value (signed) 
	 *
	 * @param in  the input binary string. Should have a leading "0b"
	 * @return the byte value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseBinStrToByte(String in) throws NumberFormatException {
		byte val = 0;
		byte digit = 0;
		byte weight = 1;
		in = in.substring(2);

		for (int i = in.length()-1; i >= 0; i--) {
			if (in.charAt(i) == '_' || in.charAt(i) == ' ') continue;
			digit = (byte)(in.charAt(i) - '0');
			val += digit * weight;
			weight = (byte) (weight * 2);
		}
		return val;
	}
	
	/**
	 * Parses an unsigned hex string and returns the equivalent integer value (signed).
	 *
	 * @param in  the input hex string. Should have a leading "0x"
	 * @return the integer value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static int parseHexStrToInt(String in) throws NumberFormatException {
		return 0;
	}
	
	/**
	 * Parses an unsigned hex string and returns the equivalent byte value (signed).
	 *
	 * @param in  the input hex string. Should have a leading "0x"
	 * @return the byte value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseHexStrToByte(String in) throws NumberFormatException {
		return 0;
	}

	/**
	 * Returns the equivalent unsigned binary string (32 bits)
	 *
	 * @param in the integer to convert
	 * @return the equivalent binary string representation (32 bits)
	 */
	public static String intToBinaryString(int in) {
		return("");
	}
	
	/**
	 * Returns the equivalent unsigned binary string (8 bits)
	 *
	 * @param in the byte to convert
	 * @return the equivalent binary string representation (8 bits)
	 */
	public static String byteToBinaryString(byte in) {
		return("");
	}
	
	/**
	 * Returns the equivalent unsigned hex string (8 hex chars)
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representation (8 hex chars)
	 */
	public static String intToHexString(int in) {
		return("");
	}
	
	/**
	 * Returns the equivalent unsigned hex string (2 hex chars)
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representation (2 hex chars)
	 */
	public static String byteToHexString(byte in) {
		return("");	
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// You should write basic testing of each of your methods here.
		// I will provide a more comprehensive testing using JUnit.
		
		System.out.print("0b0000_0001" + " = "); 
		System.out.println(parseBinStrToByte("0b0000_0001")); //should print 1
		
		System.out.print("0b10000000" + " = "); 
		System.out.println(parseBinStrToByte("0b10000000"));  //should print -128
		
		System.out.print("0b11111111" + " = "); 
		System.out.println(parseBinStrToByte("0b11111111"));  //should print -1
		
		
		
		System.out.print("0b0111_1111_1111_1111_1111_1111_1111_1111" + " = "); 
		System.out.println(parseBinStrToInt("0b0111_1111_1111_1111_1111_1111_1111_1111")); //should print 2147483647
		
		System.out.print("0b1000_0000_0000_0000_0000_0000_0000_0000" + " = "); 
		System.out.println(parseBinStrToInt("0b1000_0000_0000_0000_0000_0000_0000_0000")); //should print -2147483648
		
		System.out.print("0b1111_1111_1111_1111_1111_1111_1111_1111" + " = "); 
		System.out.println(parseBinStrToInt("0b1111_1111_1111_1111_1111_1111_1111_1111")); //should print -1
		
		
		
		System.out.print("0" + " = "); 
		System.out.println(parseByte("0")); //should print 0
		
		System.out.print("12__7" + " = "); 
		System.out.println(parseByte("12__7")); //should print 127
		
		System.out.print("-1____2__8" + " = "); 
		System.out.println(parseByte("-1____2__8")); //should print -128
		
		
		
		System.out.print("000010_2__7" + " = "); 
		System.out.println(parseInt("000010_2__7")); //should print 1027
		
		System.out.print("-000000" + " = "); 
		System.out.println(parseInt("-000000")); //should print 0
		
		System.out.print("+135" + " = "); 
		System.out.println(parseInt("+135")); //should print 135

	}

}
