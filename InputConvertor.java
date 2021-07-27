import java.util.StringTokenizer;

public class InputConvertor {
    int[] StringArray(String s){
        /*
            This method is to convert the
            input string into the desired 0-index
            array.
         */
        StringTokenizer st=new StringTokenizer(s,"[], "); // using the space (' '), Square Brackets and comma as delimiters.
        int[] passId = new int[st.countTokens()];
        int i=0;
        while(st.hasMoreElements()){
            passId[i]= Integer.parseInt( (String)st.nextElement());
            i++;
        }
        return passId;
    }
     int[][] StringArrays(String s){
        StringTokenizer st = new StringTokenizer(s,",[] "); // using the space (' '), Square Brackets and comma as delimiters.
        int noOfContingent = st.countTokens()/2;
        int[][] arr = new int[noOfContingent][2];
        int i=0;
        while(st.hasMoreElements()){
            arr[i][0]=Integer.parseInt((String)st.nextElement());
            arr[i][1]=Integer.parseInt((String)st.nextElement());
            i++;
        }
        return arr;
    }
}
