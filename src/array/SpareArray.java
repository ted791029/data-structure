package array;

public class SpareArray {
	
	/**
	 * �ഫ���
	 * 1.�Ыؤ@�ӤG���}�C�Arow = spareArray[0][0]�A column = spareArray[0][1]
	 * 2.�ѲĤG�C�}�l�M���}���}�C�A�N�ȼg�^�G���}�C
	 * @param twoDimensionalArray
	 * @return
	 */
	public Integer[][] toTwoDimensionalArray(Integer[][] spareArray){
		Integer[][] twoDimensionalArray = new Integer[spareArray[0][0]][spareArray[0][1]];
		for(int i = 1; i < spareArray.length; i++) {
			twoDimensionalArray[spareArray[i][0]][spareArray[i][1]] = spareArray[i][2];
		}
		return twoDimensionalArray;
	}
	/**
	 * �ഫ���
	 * 1.�M����ӤG���}�C�A���o�ݰO�����Ȭ�sum
	 * 2.�Ыص}���}�C�Arow = sum + 1�A column = 3
	 * 3.�]�wspare[0] = [�G���}�Crow, �G���}�Ccolumn, sum]
	 * 4.�̧ǱN[�ݭn��������row, �ݭn��������column, �ݭn��������]�g�Jspare��
	 * @param spareArray
	 * @return
	 */
	public Integer[][] toSpareArray(Integer[][] twoDimensionalArray){
		int sum = 0;
		
		for(int i = 0; i < twoDimensionalArray.length; i++) {
			for(int j = 0; j < twoDimensionalArray[i].length; j++) {
				if(twoDimensionalArray[i][j] != null) {
					sum++;
				}
			}
		}
		
		Integer[][] spare = new Integer[sum + 1][3];
		
		spare[0][0] = twoDimensionalArray.length;
		spare[0][1] = twoDimensionalArray[0].length;
		spare[0][2] = sum;
		
		int index = 1;
 		for(int i = 0; i < twoDimensionalArray.length; i++) {
			for(int j = 0; j < twoDimensionalArray[i].length; j++) {
				if(twoDimensionalArray[i][j] != null) {
					spare[index][0] = i;
					spare[index][1] = j;
					spare[index][2] = twoDimensionalArray[i][j];
					index++;
				}
			}
		}
 		
 		return spare;
	}
}
