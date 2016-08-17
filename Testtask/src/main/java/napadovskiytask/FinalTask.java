package napadovskiytask;

public class FinalTask{
	
	
	public boolean findSubString(String origin, String sub){
		
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();

        int counter =0;
        int indFind =0;
        boolean findString = false;

        for(int i=0; i<subArray.length; i++){
            char symbol = subArray[i];
            for (int j = indFind; j<originArray.length; j++ ){
                if(symbol == originArray[j]){
                    indFind = ++j;
                    counter ++;
                    break;
                }
                else{
                    counter =0;
                }
            }
        }
        if(counter == subArray.length){
            findString = true;
        }
        return findString;
	}
}