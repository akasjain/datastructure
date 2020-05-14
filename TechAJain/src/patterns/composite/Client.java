package patterns.composite;

/**
 * Class - https://howtodoinjava.com/wp-content/uploads/2015/10/composite-design-pattern.png
 *
 * https://howtodoinjava.com/design-patterns/structural/composite-design-pattern/
 */
public class Client {

    public void testConstant() {
        double testValue = 3.0;
        Expression e = new Constant(testValue);
        System.out.println(e.getValue() == testValue);
        //assertEquals(testValue, e.getValue(), 0.0);
    }

    public void testAdder() {
        double testValueA = 2.0;
        double testValueB = 4.0;
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Adder(left, right);
        System.out.println(e.getValue() == testValueA + testValueB);
        //assertEquals((testValueA+testValueB), e.getValue(), 0.0);
    }

    public void testSubtracter() {
        double testValueA = 2.0;
        double testValueB = 4.0;
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Subtracter(left, right);
        //assertEquals((testValueA-testValueB), e.getValue(), 0.0);
    }


    public void testDivider() {
        double testValueA = 2.0;
        double testValueB = 4.0;
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Divider(left, right);
        //assertEquals((testValueA/testValueB), e.getValue(), 0.0);
    }

    public void testMultiplier() {
        double testValueA = 2.0;
        double testValueB = 4.0;
        Expression left = new Constant(testValueA);
        Expression right = new Constant(testValueB);
        Expression e = new Multiplier(left, right);
        //assertEquals((testValueA*testValueB), e.getValue(), 0.0);
    }

    public void testComplexExpression() {
        Expression e =
                new Divider(
                        new Multiplier(
                                new Adder(new Constant(3.0), new Constant(5.0)),
                                new Constant(100.0)
                        ),
                        new Adder(new Constant(2.0), new Constant(64.0))
                );
        // we know this would be equal 12.121212121212...
        //assertEquals(12.1212121212, e.getValue(), 0.00001);
    }
}
