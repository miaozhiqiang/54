class CalssLoad  implements Cloneable{
      public static int k = 0;
      public static CalssLoad t1 = new CalssLoad("t1");
      public static CalssLoad t2 = new CalssLoad("t2");
      public static int i = print("i");
      public static int n = 99;

      public int j = print("j");
      {
          print("构造块");
      }

      static {
          print("静态块");
      }

      public CalssLoad(String str) {
          System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
          ++n; ++ i;
      }

      public static int print(String str){
          System.out.println((++k) +":" + str + "   i=" + i + "   n=" + n);
          ++n;
          return ++ i;
      }

      public static void main(String[] args){
          CalssLoad t = new CalssLoad("init");
      }
    }