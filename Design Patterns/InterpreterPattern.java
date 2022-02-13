

class Scratch {
    public static void main(String[] args) {
        Expression expressionOne=new TerminalExpression("Toy");

        Expression expressionTwo=new TerminalExpression("Train");

        Expression expressionThree=new AndExpression(expressionOne,expressionTwo);
        Expression expressionFour=new OrExpression(expressionOne,expressionTwo);
        System.out.println(expressionThree.interpret("Toy ,Train"));


        System.out.println(expressionFour.interpret("Toy, Train"));
        System.out.println(expressionFour.interpret("Aeroplane"));
    }

}
/*
Expression interface - base for a concrete interpreter class
 */
interface Expression{
    boolean interpret(String value);
}
/*
Terminal Expression class to interpret the terminal symbols
 */
class TerminalExpression implements Expression {

    String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String value) {
        return value.contains(data);
    }
}
/*
Another concrete class to perform "AND" operation
 */
class AndExpression implements Expression{
    Expression expressionOne,expressionTwo;

    public AndExpression(Expression expressionOne, Expression expressionTwo) {
        this.expressionOne = expressionOne;
        this.expressionTwo = expressionTwo;
    }

    @Override
    public boolean interpret(String value) {
        return this.expressionOne.interpret(value) && this.expressionTwo.interpret(value);
    }
}
/*
Another concrete class to perform "OR" operation
 */
class OrExpression implements Expression{
    Expression expressionOne,expressionTwo;

    public OrExpression(Expression expressionOne, Expression expressionTwo) {
        this.expressionOne = expressionOne;
        this.expressionTwo = expressionTwo;
    }

    @Override
    public boolean interpret(String value) {
        return this.expressionOne.interpret(value)&& this.expressionTwo.interpret(value);
    }
}
