public class Test {
      class A {
            String str = "ab";

            A() {
                  printLength();
            }

            void printLength() {
                  System.out.println(str.length());
            }
      }

      class B extends A {
            String str = "abc";

            public B() {

            }

            void printLength() {
                  System.out.println();
                  System.out.println(str.length());
            }
      }

      public static void main(String[] args) {
            Test.A testA = new Test().new A();
            testA.printLength();
            System.out.println("-----------------------------------");
            System.out.println("Exception in thread \"main\" java.lang.NullPointerException: Cannot invoke \"String.length()\" because \"this.str\" is null");
            Test.B testB = new Test().new B();
            testB.printLength();

            System.out.println();
      }
}