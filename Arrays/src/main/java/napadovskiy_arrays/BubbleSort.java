package napadovskiy_arrays;

/**
	*Class BubbleSort для сортировки массива
	*@author napadovskiy
	*@since 07.08.2016
	*@version 1
*/

class BubbleSort {
	/**
		*Сортировка массива
	*/
    
	public void sortArray(int[] nums) {
	   
        for (int firstCounter = 0; firstCounter <= nums.length; firstCounter++) {
            int secondCounter = 0;
            while (secondCounter < nums.length-1) {
                int tempvalue = nums[secondCounter];
                if (tempvalue > nums[secondCounter + 1]) {
                    nums[secondCounter] = nums[secondCounter + 1];
                    nums[secondCounter + 1] = tempvalue;
                }
                secondCounter++;
            }
        }
		
	}
}