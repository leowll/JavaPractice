package basic;

import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionSample {
	
	/**
	 *  IllegalArgumentException属于RuntimeException
	 *  不需要明确地在函数声明中抛出异常
	 * @param n
	 */
	public static void inputInt(int n) {
		if (n < 0)
			throw new IllegalArgumentException("n must be positive!");
	}
	
	/**
	 * FileNotException不属于RuntimeException
	 * 需要在函数声明中表明throws或者在程序中try catch
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	public static void fileException(String filePath) throws FileNotFoundException{
		File f = new File(filePath);
		if( f.exists() == false){
			throw new FileNotFoundException();
		}
	}

	public static void main(String[] args) {
		inputInt(-1);
	}
}
