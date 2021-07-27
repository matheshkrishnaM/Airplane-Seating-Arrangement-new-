import java.util.*;

/*
Test Case-1
[[3,2], [4,3], [2,3], [3,4]]
[29,59,14,11,3,13,15,18,12,16,6,17,7,47,61,5,21,2,41,9,10,8,19,1,4]

Test Case-2
[[3,2], [4,3], [2,3], [3,4], [4,5]]
[29,59,14,11,3,13,15,18,12,16,6,17,7,47,61,5,21,2,41,9,8,19,1,4,72,85,83,99,92,101,10,76,68,80]

Test Case-3
[[3,2], [4,3], [2,3], [3,4], [4,5],[7,8]]
[29,59,14,11,3,13,15,18,12,16,6,17,7,47,61,5,21,2,41,9,8,19,1,4,72,85,83,99,92,101,10,76,68,80,31,32,33,34,35,36,37,38,39,40]
 */


class Passenger{
    int maximumColumn;
    int maximumRow;
    int totalColumn;
    int noOfContingent;
    int[][] seat;
    int[] passengerId;
    int[][] seatType;
    int[][] contingent;


    Passenger(){
        /*
        This is a constructor
        that gets input from the user
        as String which is later converted to
        the appropriate  data types.It
        does the basic necessity function for the
        seat allocation.
         */
        Scanner sc = new Scanner(System.in);
        Prioritize p = new Prioritize();
        String array = sc.nextLine();
        String passenger = sc.nextLine();
        InputConvertor ic = new InputConvertor();
        passengerId = (ic.StringArray(passenger));
        contingent = (ic.StringArrays(array));
        noOfContingent = contingent.length;
        passengerId =  p.Priority(passengerId);
        findMaximumRowColumn(contingent);
        System.out.println(maximumColumn+" "+maximumRow);
        DisplayHead(contingent);
        Allotment();
        sc.close();
    }
    void findMaximumRowColumn(int[][] contingent){
        /*
        This method finds the maximum row, 
        column and the total length of first 
        row with all containment.
         */
        maximumColumn=0;
        maximumRow=0;
        totalColumn=0;
        for (int[] ints : contingent) {
            maximumRow = Math.max(maximumRow, ints[1]);
            maximumColumn = Math.max(maximumColumn, ints[0]);
            totalColumn = totalColumn + ints[0];
        }
    }
    void Allotment(){
        /*
            This method allocates seats
            as per the priority mentioned.
         */
        seat = new int[maximumRow][totalColumn];
        int index=0;
        for(int i=0;i<maximumColumn;++i){//Aisle Seat Allocation
            for(int j=0;j<totalColumn;++j){
                if(seatType[j][0]==2&&i<seatType[j][1]&&index<passengerId.length){
                    seat[i][j]=passengerId[index];
                    index++;
                }
            }
        }
        for(int i=0;i<maximumColumn;++i){//Window Seat Allocation
            for(int j=0;j<totalColumn;++j){
                if(seatType[j][0]==1&&i<seatType[j][1]&&index<passengerId.length){
                    seat[i][j]=passengerId[index];
                    index++;
                }
            }
        }
        for(int i=0;i<maximumColumn;++i){//Middle Seat Allocation
            for(int j=0;j<totalColumn;++j){
                if(seatType[j][0]==3&&i<seatType[j][1]&&index<passengerId.length){
                    seat[i][j]=passengerId[index];
                    index++;
                }
            }
        }
        System.out.println();
        for(int i=0;i<maximumColumn;++i){
            for(int j=0;j<totalColumn;++j){
                if(seat[i][j]!=0)
                    System.out.print(seat[i][j]+"\t");
                else{
                    if(i<seatType[j][1]){
                        System.out.print("xx"+"\t");
                    }
                    else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
    void DisplayHead(int[][] contingent) {
        /*
        The DisplayHead() method prints the seats
        type of a column.
         */
        int count = 0;
        seatType = new int[totalColumn][2]; // column type as ww, aa and mm
        for (int i = 0; i < contingent.length; ++i) { // for the display of seat type
            int l = contingent[i][0];

            if (i == 0) {
                System.out.print("ww  ");
                seatType[count++][0] = 1;
            } else {
                System.out.print("aa  ");
                seatType[count++][0] = 2;
            }
            for (int j = 1; j < l - 1; ++j) {
                System.out.print("mm  ");
                seatType[count++][0] = 3;
            }
            if (i == contingent.length - 1) {
                System.out.print("ww  ");
                seatType[count++][0] = 1;
            } else {
                System.out.print("aa  ");
                seatType[count++][0] = 2;
            }
        }
        int z=0;
        for(int i=0;i<noOfContingent;++i){
            for(int j =0;j<contingent[i][0];++j){
                seatType[z+j][1] =  (contingent[i][1]);
            }
            z=z+contingent[i][0];
        }

    }

}
