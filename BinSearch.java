//BENEDICT BOLTON
// HW#33
// PD08
//2013-11-26


/*==================================================
  class BinSearch
  skeleton file
  ==================================================*/

public class BinSearch {


    /*==================================================
      int binSearch(int[],int) -- searches an array of ints for target int
      pre:  input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearch ( int[] a, int target ) {
	//uncomment exactly 1 of the 2 stmts below:
	//return binSearchIter( a, target, 0, a.length-1 );
	return binSearchRec( a, target, 0, a.length-1 );
    }


    /*==================================================
      int binSearchIter(int[],int) -- searches an array of ints for target int,
                                   Uses Iteration.
      pre:  input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
	int mid = 0;
	int foo = 0;
	while ( foo != target) {
	    mid = (int) Math.round( ((lo + hi)/2.0) );
	    foo = a[mid];
	    if ( foo == target) {
		break;
	    }
	    if ( hi == lo) {
		return -1;
	    }
	    if (foo < target) {
		lo = mid;
	    }
	    else {
		hi = mid;
	    }
	}
	return mid;
    }


    /*==================================================
      int binSearchRec(int[],int) -- searches an array of ints for target int
      Uses Recursion.
      pre:  input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearchRec( int[] a, int target, int lo, int hi ) {
	int mid = (int) Math.round( ((lo + hi)/2.0) );
	int foo = a[mid];
	if ( foo == target) {
	    return mid;
	}
	else {	
	    if (hi == lo) {
		return -1;
	    }
	    if ( foo < target ) {
		return binSearchRec( a, target, mid, hi) ;
	    }
	    else {
		return binSearchRec( a, target, lo , mid) ;
	    } 
	}
    }



    /*==================================================
      int isSorted(int[]) -- checks if array is sorted in ascending order
      pre:  input is array of ints
      post: true if sorted in ascending order, false otherwise
      ==================================================*/
    private static boolean isSorted( int[] arr ) {
	int prev = 0;
	for (int cur: arr) {
	    if (cur < prev) {
		return false;
	    }
	    prev = cur;
	}
	return true;
    }


    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( int[] arr ) {
	String output = "[ "; 

	for( int i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {



	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	int[] iArr = { 2, 4, 6, 8, 6, 42 };
	printArray( iArr );
	System.out.println( "sorted? -- " + isSorted(iArr) );

	int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	printArray( iArr2 );
	System.out.println( "sorted? -- " + isSorted(iArr2) );

	int[] iArr3 = { 2, 4, 7, 42, 13, 1};
	printArray( iArr3 );
	System.out.println( "sorted? -- " + isSorted(iArr3) );

	//search for 6 in array 
	System.out.println( binSearch(iArr2,6) );

	//search for 43 in array 
	System.out.println( binSearch(iArr2,43) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/*==================================================
	==================================================*/

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }//end main()

}//end class BinSearch
