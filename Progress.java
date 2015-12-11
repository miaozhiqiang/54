import java.io.IOException;
import java.util.stream.Stream;

public class Progress {

    private final static String COMMA = ",";

    private final static String EROOR = "invalid";


    public static void main( String[] args ) throws IOException {

        int c;
        StringBuilder input = new StringBuilder();
        while ( ( c = System.in.read() ) != -1 ) {
            try {
                if ( c == 13 ) {
                    continue;
                }
                if ( c == 10 ) {

                    String[] inputLine = input.toString().split( COMMA );
                    if ( inputLine.length != 3 ) {
                        System.out.println( EROOR );
                        break;
                    }
                    int sum = Integer.valueOf( inputLine[0] );

                    int pro = Integer.valueOf( inputLine[1] );

                    if ( inputLine[2].length() != 1
                                    || !( ">".equals( inputLine[2] ) || "+".equals( inputLine[2] ) || "-".equals( inputLine[2] ) || "#"
                                                    .equals( inputLine[2] ) ) ) {
                        System.out.println( EROOR );
                        break;
                    }
                    if ( sum < 10 || sum > 100 ) {
                        System.out.println( EROOR );
                        break;
                    }

                    if ( pro < 1 || sum > 100 ) {
                        System.out.println( EROOR );
                        break;
                    }
                    if ( pro > sum ) {
                        System.out.println( EROOR );
                        break;
                    }
                    float loop = pro / ( sum + 0.0f ) * 100;

                    Stream<String> stream = Stream.generate( ( ) -> inputLine[2] ).limit( (int) loop );
                    stream.forEach( System.out::print );

                    input = new StringBuilder();
                    continue;

                }

                input.append( (char) c );
            } catch ( Exception ex ) {
                System.out.println( EROOR );
            }

        }

    }
}
