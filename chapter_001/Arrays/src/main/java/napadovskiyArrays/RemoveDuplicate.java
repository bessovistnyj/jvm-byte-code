package napadovskiyArrays;

/**
	*Class RemoveDuplicate для удаления дублей из массива
	*@author napadovskiy
	*@since 15.08.2016
	*@version 1
*/


public class RemoveDuplicate {
 /**
	*@param inputString
	*creat new array with length of inputString
	*and fill it with unique elements; 
	*and decrement counter
	*then creat new array with length of counter
*/     
  
	public String[] removeDuplicate(String[] inputString) {
        String[] tempString = new String[inputString.length];

        int counter = 0;

        for (int i = 0; i < inputString.length; i++) {
            if (i == 0) {
                tempString[counter] = inputString[i];
                counter++;
            } else {
                if (!findeElement(tempString, inputString[i])) {
                    tempString[counter] = inputString[i];
                    counter++;
                }
            }
        }
        
		String[] resultString = new String[counter];
		for(int i=0; i<counter; i++){
			resultString[i] = tempString[i];
		}
		return resultString;
    }

	/**
		*@param tempString;
		*@param value;
		*@return findeElement;
		*find value in tempString 
		*If found then it is not necessary to add 
	*/     


    boolean findeElement(String[] tempString, String value) {
        boolean findeElement = false;
        for (int i = 0; i < tempString.length; i++) {
            if (tempString[i] != null && tempString[i].equals(value)) {
                findeElement = true;
                break;
            }
        }
        return findeElement;
    }
}
