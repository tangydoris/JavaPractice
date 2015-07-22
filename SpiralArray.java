import java.util.logging.Logger;

public class SpiralArray {
	
	/*
	 * #8
	 * Make a spiral 2d array given the length of each side
	 * The number at the first index is 1
	 * eg. input 3
	 * 1 2 3
	 * 8 9 4
	 * 7 6 5
	 */
	
	static Logger logger = Logger.getLogger("SpiralArray.class");
	
	public static int[][] makeSpiral(int length) {
		if (length>Math.sqrt(Integer.MAX_VALUE)) {
			logger.severe("Input length is too large");
			throw new LargeNumberException("Input length is too large");
		}
		
		if (length==0) {
			logger.severe("Cannot make spiral of zero length");
			throw new RuntimeException("Cannot make spiral of zero length");
		}
		
		int[][] out = new int[length][length];
		int count=1;
		int iStart=0, iEnd=length-1;
		
		while (iStart<=iEnd) {
			int j=iStart, k=iStart;
			for (int i=0; i<4; i++) {
				
				if(iStart==iEnd) {
					out[j][k]=count;
					break;
				}
				
				switch (i) {
					// go right
					case 0:	while (k<iEnd)
								out[j][k++]=count++;
							break;
					// go down
					case 1:	while (j<iEnd)
								out[j++][k]=count++;
							break;
					// go left
					case 2:	while (k>iStart)
								out[j][k--]=count++;
							break;
					// go up
					case 3:	while (j>iStart)
								out[j--][k]=count++;
							break;
				}
			}
			iStart++;
			iEnd--;
		}
		
		// print output
		for (int i=0; i<length; i++) {
			for (int j=0; j<length; j++)
				System.out.print(out[i][j]+"\t");
			System.out.println("");
		}
		System.out.println("");
		
		return out;
	}

	public static void main(String[] args) {
		makeSpiral(1);
		makeSpiral(2);
		makeSpiral(3);
		makeSpiral(4);
	}

}
