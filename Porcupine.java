import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Porcupine {

    private static final String SPACE = " ";

    private static final int MAX_HP = 99;


    public static void main( String[] args ) throws IOException {

        int c;
        int lineNum = 1;

        int porcupineNum = 0;

        StringBuilder input = new StringBuilder();

        List<LineInput> lineInputList = new ArrayList<>();
        while ( ( c = System.in.read() ) != -1 ) {

            if ( c == 10 ) {
                continue;
            }
            if ( c == 13 ) {

                if ( porcupineNum <= 0 ) {

                    porcupineNum = Integer.valueOf( input.toString() );
                    input = new StringBuilder();
                    continue;

                }

                String[] point = input.toString().split( SPACE );
                LineInput lineInput = new LineInput();
                lineInput.setMoster( Integer.valueOf( point[0] ) );
                lineInput.setHuman( Integer.valueOf( point[1] ) );
                lineInput.setTurtle( Integer.valueOf( point[2] ) );
                lineInputList.add( lineInput );
                lineNum++;

                input = new StringBuilder();

                if ( lineNum == porcupineNum + 1 ) {
                    printSum( lineInputList );
                    break;
                }
                continue;
            }

            input.append( (char) c );

        }

    }


    private static void printSum( List<LineInput> lineInputList ) {

        int loop = 0;
        int[] array = new int[lineInputList.size()];

        for ( LineInput li : lineInputList ) {

            array[loop] = li.getHuman();
            loop++;

        }

        loop = 0;

        for ( int i = 0; i < array.length; i++ ) {
            int[] cache = new int[i + 1];
            int ceng = -1;
            int cengQuit = i;
            int startPiont = 0;
            cir( ceng, cengQuit, startPiont, array, cache, MAX_HP );

            System.out.println( cache );
        }
    }


    // 递归求结果
    public static void cir( int ceng, int cengQuit, int startPiont, int[] array, int[] cache, int sum ) {

        ceng++;
        for ( int i = startPiont; i < array.length; i++ ) {
            cache[ceng] = array[i];
            if ( ceng == cengQuit ) {
                if ( getSum( cache ) == sum ) {
                    printcache( cache );
                }
                if ( getSum( cache ) > sum ) {
                    break;
                }
            }
            if ( ceng < cengQuit ) {
                startPiont = i + 1;
                cir( ceng, cengQuit, startPiont, array, cache, sum );
            }
        }
    }


    public static void printcache( int[] cache ) {

        for ( int i = 0; i < cache.length; i++ ) {
            System.out.print( cache[i] + "," );
        }
        System.out.println();
    }


    public static int getSum( int[] cache ) {

        int sum = 0;
        for ( int i = 0; i < cache.length; i++ ) {
            sum = sum + cache[i];
        }
        return sum;
    }



    private static class LineInput {

        private int moster;

        private int human;

        private int turtle;


        /**
         * mosterを取得します。
         *
         * @return moster moster
         */
        public final int getMoster() {

            return moster;
        }


        /**
         * mosterを設定します。
         *
         * @param moster
         *            moster
         */
        public final void setMoster( int moster ) {

            this.moster = moster;
        }


        /**
         * humanを取得します。
         *
         * @return human human
         */
        public final int getHuman() {

            return human;
        }


        /**
         * humanを設定します。
         *
         * @param human
         *            human
         */
        public final void setHuman( int human ) {

            this.human = human;
        }


        /**
         * turtleを取得します。
         *
         * @return turtle turtle
         */
        public final int getTurtle() {

            return turtle;
        }


        /**
         * turtleを設定します。
         *
         * @param turtle
         *            turtle
         */
        public final void setTurtle( int turtle ) {

            this.turtle = turtle;
        }

    }

}
