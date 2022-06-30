package array;

public class SpareArray {
	
	/**
	 * 轉換思路
	 * 1.創建一個二維陣列，row = spareArray[0][0]， column = spareArray[0][1]
	 * 2.由第二列開始遍歷稀疏陣列，將值寫回二維陣列
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
	 * 轉換思路
	 * 1.遍歷整個二維陣列，取得需記錄的值為sum
	 * 2.創建稀疏陣列，row = sum + 1， column = 3
	 * 3.設定spare[0] = [二維陣列row, 二維陣列column, sum]
	 * 4.依序將[需要紀錄的值row, 需要紀錄的值column, 需要紀錄的值]寫入spare中
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
