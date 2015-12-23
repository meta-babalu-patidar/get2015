/**
 *  @author Babalu Patidar
 *  
 * 	Class to differentiate String, StringBuilder and StringBuffer
 * 
 *  1. String is stored in constant string pool and its value can not be modified.
 *  2. String is created in constant pool and referenced by the input variable.
 *  3. StringBuffer stored in heap and its value can be changed.
 *  4. StringBuilder also stored in the heap and its value can be modified.
 *  5. Performance of stringBuffer is slow but performance of stringBuilder is fast.
 */

package String_StringBuffer_StringBuilder;

public class StringStringBufferAndStringBuilder {

	public static void main(String[] args) {
		String input = "Babalu";
		System.out.println("String \nAddress of " + input + " = "
				+ System.identityHashCode(input));
		input = input + " Patidar";
		System.out.println("Address of " + input + " = "
				+ System.identityHashCode(input));

		StringBuffer inputBuffer = new StringBuffer("Babalu");
		System.out.println("StringBuffer \nAddress of " + inputBuffer + " = "
				+ System.identityHashCode(inputBuffer));

		inputBuffer = inputBuffer.append(" Patidar");
		System.out.println("Address of " + inputBuffer + " = "
				+ System.identityHashCode(inputBuffer));

		StringBuilder inputBuilder = new StringBuilder("Babalu");
		System.out.println("StringBuilder \nAddress of " + inputBuilder + " = "
				+ System.identityHashCode(inputBuilder));

		inputBuilder = inputBuilder.append(" Patidar");
		System.out.println("Address of " + inputBuilder + " = "
				+ System.identityHashCode(inputBuilder));

		// Performance of stringBuffer is slow but performance of stringBuilder is fast.

		long currentTimeBuffer = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			inputBuffer = inputBuffer.append(" Metacube");
		}

		System.out.println("Time for inputBuffer = "
				+ (System.currentTimeMillis() - currentTimeBuffer));

		long currentTimeBuilder = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			inputBuilder = inputBuilder.append(" Metacube");
		}

		System.out.println("Time for inputBuilder = "
				+ (System.currentTimeMillis() - currentTimeBuilder));
	}

}
