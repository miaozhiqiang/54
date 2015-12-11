import java.io.IOException;
import java.util.regex.Pattern;

public class MyNmaber {

    /**
     * 11,12桁半角数字
     */
    private static final String CHECK_REGEX = "[0-9]{11,12}";


    public static void main( String[] args ) throws IOException {

        int c;
        StringBuilder input = new StringBuilder();
        while ( ( c = System.in.read() ) != -1 ) {

            if ( c == 10 ) {

                checkMyNmber( input.toString() );
                input = new StringBuilder();
                continue;
            }

            input.append( (char) c );

        }

    }


    private static void checkMyNmber( String myNmber ) {

        if ( !Pattern.matches( CHECK_REGEX, myNmber ) ) {
            System.out.println( "Error" );
            return;
        }

        String checkDigit = calcDigit( myNmber.substring( 0, 11 ) );

        if ( myNmber.length() == 11 ) {
            System.out.println( checkDigit );
        } else {
            if ( checkDigit.equals( myNmber.substring( 11, 12 ) ) ) {
                System.out.println( "OK" );
            } else {
                System.out.println( "NG" );
            }

        }
    }


    private static String calcDigit( String number ) {

        int sum = 0;
        for ( int i = 1; i <= 11; i++ ) {

            int pn = Integer.valueOf( number.substring( 11 - i, 12 - i ) );
            int qn = i <= 6 ? i + 1 : i - 5;
            sum += pn * qn;
        }

        int mod = sum % 11;

        if ( mod <= 1 ) {
            return "0";
        } else {
            return String.valueOf( 11 - mod );

        }

    }
}
