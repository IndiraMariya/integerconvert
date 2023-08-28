
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
		boolean negative = false;
		final int MAX = 2147483647;
		final int maxDigit = 9;
		
		if (in.equals("") || in.equals("+") || in.equals("-") || in.equals("_") )
			throw new NumberFormatException("Invalid Input String.");
		if (in.charAt(0) == '-') negative = true;
		if (in.charAt(0) == '+' || in.charAt(0) == '-') in = in.substring(1);
		for(int i = 0; i < in.length();i++) {
			if (in.charAt(i)-'0'> maxDigit  || in.charAt(i)-'0'< 0) {
				if (in.charAt(i) != '_') throw new NumberFormatException("String must have numbers or underscores");
			}
			if (in.equals("_"))throw new NumberFormatException("String must have numbers");
			if (in.charAt(in.length()-1-i) == '_' || in.charAt(in.length()-1-i) == ' ') continue;
			int digit = in.charAt(in.length()-1-i) - '0';
			
			if (!negative && MAX / weight < digit)throw new NumberFormatException("Number is out of range");
			if (MAX / weight < digit) throw new NumberFormatException("Number is out of range");
			
			if (digit != 0 && negative && (MAX - (digit * weight) + 1 < val))
				throw new NumberFormatException("Number is out of range");
			else if (digit != 0 && !negative && MAX - val < (digit * weight)) 
				throw new NumberFormatException("Number is out of range");
			val += digit * weight;
			weight = weight * 10;
		}
		if (negative) return (val * (-1));
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
		byte weight = 1;
		boolean negative = false;
		final byte MAX = 127;
		
		if (in.equals("") || in.equals("+") || in.equals("-") || in.equals("_") )
			throw new NumberFormatException("Invalid Input String.");
		if (in.charAt(0) == '-') negative = true;
		if (in.charAt(0) == '+' || in.charAt(0) == '-') in = in.substring(1);
		
		for(int i = 0; i < in.length();i++) {
			if (in.charAt(i)-'0'> 9  || in.charAt(i)-'0'< 0) {
				if (in.charAt(i) != '_') throw new NumberFormatException("String needs numbers or underscores");
			}
			if (in.equals("_"))throw new NumberFormatException("String must have numbers");
			if (in.charAt(in.length()-1-i) == '_' || in.charAt(in.length()-1-i) == ' ') continue;
			int digit = in.charAt(in.length()-1-i) - '0';
			
			if (digit != 0 && !negative && MAX / weight < digit)
				throw new NumberFormatException("Digit is too high");
			else if (digit != 0 && MAX / weight < digit) 
				throw new NumberFormatException("Digit is too low");
			
			if (digit != 0 && negative && (MAX - (digit * weight) + 1 < val))
				throw new NumberFormatException("Number is too high");
			else if (digit != 0 && !negative && MAX - val < (digit * weight)) 
				throw new NumberFormatException("Number is too low");
			val += digit * weight;
			weight = (byte) (weight * 10);
		}
		if (negative) return (byte)(val * (-1));
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
		int count = 0;
		final int MAXLEN = 32;
		
		if (in.equals("")) throw new NumberFormatException("empty string");
		if (in.length()<= 2 || !(in.substring(0,2).equals("0b"))) 
			throw new NumberFormatException("String needs to start with 0b");
		in = in.substring(2);

		for (int i = in.length()-1; i >= 0; i--) {
			if (!(in.charAt(i) == '0' || in.charAt(i) == '1' || in.charAt(i) == '_')) 
				throw new NumberFormatException("String needs to contain 0,1, or _");
			if (in.charAt(i) == '_') {
				count ++;
				continue;
			}
			if (i == 0 && in.length() -count > MAXLEN || in.length() - count == 0) 
				throw new NumberFormatException("too long input string");
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
		int count = 0;
		final int MAXLEN = 8;
		
		if (in.equals("")) throw new NumberFormatException("empty string");
		if (in.length()<= 2 || !(in.substring(0,2).equals("0b"))) 
			throw new NumberFormatException("String needs to start with 0b");
		in = in.substring(2);
		for (int i = in.length()-1; i >= 0; i--) {
			if (!(in.charAt(i) == '0' || in.charAt(i) == '1' || in.charAt(i) == '_')) 
				throw new NumberFormatException("String needs to contain 0,1, or _");
			
			if (in.charAt(i) == '_') {
				count ++;
				continue;
			}
			if (i == 0 && in.length() - count > MAXLEN || in.length() - count == 0) 
				throw new NumberFormatException("too long input string");
			
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
		int digit = 0; 
		int weight = 1;
		int sum = 0;
		int base = 16;
		
		in = in.substring(2);
		for (int i = in.length()-1; i >= 0; i--) {
			digit = in.charAt(i) - '0';
			if (digit > 9) digit = in.charAt(i) - 'W';

			sum += digit * weight;
			weight = weight * base;
		}
		return sum;
	}
	
	/**
	 * Parses an unsigned hex string and returns the equivalent byte value (signed).
	 *
	 * @param in  the input hex string. Should have a leading "0x"
	 * @return the byte value of the converted string
	 * @throws NumberFormatException the number format exception
	 */
	public static byte parseHexStrToByte(String in) throws NumberFormatException {
		byte digit = 0; 
		int weight = 1;
		byte sum = 0; 
		
		in = in.substring(2);
		for (int i = in.length()-1; i >= 0; i--) {
			digit = (byte)(in.charAt(i) - '0');
			if (digit > 9) digit = (byte)(in.charAt(i) - 'W');
			sum += digit * weight;
			weight = weight * 16;
		}
		return (byte)sum;
	}

	/**
	 * Returns the equivalent unsigned binary string (32 bits)
	 *
	 * @param in the integer to convert
	 * @return the equivalent binary string representation (32 bits)
	 */
	public static String intToBinaryString(int in) {
		String str = "";
		int mask = -2147483648;
		final int BITS = 32;
		
		for (int i = 0; i < BITS; i++) {
			str += ((mask & in)!=0)?"1":"0";
			mask = mask >>> 1; 
		}
		return str;
	}
	
	/**
	 * Returns the equivalent unsigned binary string (8 bits)
	 *
	 * @param in the byte to convert
	 * @return the equivalent binary string representation (8 bits)
	 */
	public static String byteToBinaryString(byte in) {
		String str = "";
		int mask = 128;
		final int BITS = 8;
		
		for (int i = 0; i < BITS; i++) {
			str += ((mask & in)!=0)?"1":"0";
			mask = mask >>> 1;
		}
		return str;
	}
	
	/**
	 * Returns the equivalent unsigned hex string (8 hex chars)
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representation (8 hex chars)
	 */
	public static String intToHexString(int in) {
		String[] chars = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
		String str = "";
		int mask = 0x0f;
		int nibble = 0;
		int nibbles = 8;
		int nibbleBits = 4;
		
		for (int i = 0; i < nibbles; i++) {
			 nibble = (in >> (nibbleBits * (nibbles-1 - i))) & mask;
		     str += chars[nibble];
		}
		return(str);
	}
	
	/**
	 * Returns the equivalent unsigned hex string (2 hex chars)
	 *
	 * @param in the integer to convert
	 * @return the equivalent hex string representation (2 hex chars)
	 */
	public static String byteToHexString(byte in) {
		String[] chars = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
		String str = "";
		int mask = 0x0f;
		int nibble = 0;
		int nibbles = 2;
		int nibbleBits = 4;
	
		for (int i = 0; i < nibbles; i++) {
			 nibble = (in >> (nibbleBits * (nibbles-1 - i))) & mask;
		     str += chars[nibble];
		}
		return(str);
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
		
		// testing binary string to number conversions
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
		
		
		
		//testing parse int and byte
		System.out.print("0" + " = "); 
		System.out.println(parseByte("0")); //should print 0
		
		System.out.print("12__7" + " = "); 
		System.out.println(parseByte("12__7")); //should print 127
		
		System.out.print("-1____2__8" + " = "); 
		System.out.println(parseByte("-1____2__8")); //should print -128
		
		
		System.out.print("000010_2__7" + " = "); 
		System.out.println(parseInt("000010_2__7")); //should print 1027
		
		System.out.print("2_1_4_7_4_8_3_6_4_7___" + " = "); 
		System.out.println(parseInt("2_1_4_7_4_8_3_6_4_7___")); //should print 0
		
		System.out.print("+135" + " = "); 
		System.out.println(parseInt("+135")); //should print 135
		
		
		//Testing to Hex string conversions
		System.out.print("-128" + " = "); 
		System.out.println("0x" + byteToHexString((byte) -128));
		
		System.out.print("16" + " = "); 
		System.out.println("0x" + byteToHexString((byte) 16));
		
		System.out.print("127" + " = "); 
		System.out.println("0x" + byteToHexString((byte) 127));
		
		
		System.out.print("-2147483647" + " = "); 
		System.out.println("0x" + intToHexString((byte) -2147483647));
		
		System.out.print("-1" + " = "); 
		System.out.println("0x" + intToHexString((byte) -1));
		
		System.out.print("3000" + " = "); 
		System.out.println("0x" + intToHexString((byte) 3000));

	}

}
