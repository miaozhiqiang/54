import java.io.IOException;

public class Prime {

    public static void main( String[] args ) throws IOException {

        int c;
        StringBuilder input = new StringBuilder();
        while ( ( c = System.in.read() ) != -1 ) {


            if ( c == 10) {
                printPrime( input.toString() );
                input = new StringBuilder();
                continue;

            }

            input.append( (char) c );

        }
    }


    private static void printPrime( String range ) {

        if ( range.length() == 0 )
            return;

        Integer num = Integer.valueOf( range );

        int cnt = 0;
        for ( int i = 2; i <= num; i += 1 ) {
            cnt += isPrime( i );
        }

        System.out.println( cnt );

    }


    private static int isPrime( int num ) {

        int isPrime = 1;
        int k = (int) Math.sqrt( num );
        for ( int j = 2; j <= k; j++ ) {
            if ( num % j == 0 ) {
                isPrime = 0;
                break;
            }
        }
        return isPrime;
    }

}
