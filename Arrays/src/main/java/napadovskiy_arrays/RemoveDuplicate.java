package napadovskiy_arrays;

/**
	*Class RemoveDuplicate для удаления дублей элементов массива
	*@author napadovskiy
	*@since 09.08.2016
	*@version 1
*/

public class RemoveDuplicate {
    String[] firstString;
    int sizeNewArray;

    public RemoveDuplicate(String[] inputString){
        this.firstString = inputString;
        this.sizeNewArray =0;
    }

	/**
		* Find duplicate in new Array
		*@param takeString  массив в котором ищем дупликат
		*@param value		значение поиска  
		*@return itemfound
	*/
    boolean findelement(String[] takeString, String value){
        boolean itemfound = false;
        for (int i =0; i < takeString.length; i++){
            if(takeString[i] == value){
                itemfound = true;
            }
        }
        return itemfound;
    }

	/**
		Return new Array with NULL
		*@return newStringWithNull
	*/
     String[] returnNewArraysWithNull(){
        String[] newStringWithNull = new String[this.firstString.length];
        for(int i =0; i < newStringWithNull.length; i++){
            if(i == 0){
                newStringWithNull[this.sizeNewArray] = this.firstString[i];
                this.sizeNewArray++;
            }
            else{
                boolean findelement = findelement(newStringWithNull,this.firstString[i]);
                if(!findelement){
                    newStringWithNull[this.sizeNewArray] = this.firstString[i];
                    this.sizeNewArray++;
                }
            }
        }
        return newStringWithNull;
    }

	/**
		* Returns a new array without null 
		*@return newString
	*/
    public String[] removeDuplicate(){
        String[] ArrayWithNull = returnNewArraysWithNull();
        String[] newString = new String[this.sizeNewArray];
        int counter =0;
        for(int i =0; i < ArrayWithNull.length; i++){
            if(ArrayWithNull[i] != null){
                newString[counter] = ArrayWithNull[i];
                counter++;
            }
        }
        return newString;
    }
}
