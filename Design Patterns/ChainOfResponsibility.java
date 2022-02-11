class Scratch {
    public static void main(String[] args) {
        Processor processor=new NegativeProcessor(new ZeroProcessor(new PositiveProcessor(null)));
        processor.process(new Request(-1));
        processor.process(new Request(0));
        processor.process(new Request(1));
    }

}
interface Processor{
    void process(Request request);
}
 class Request{
    int number;

    public Request(int number) {
        this.number = number;
    }
}
 class PositiveProcessor implements Processor{

    private Processor processor;

    public PositiveProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void process(Request request) {
        if (request.number>0){
            System.out.println("Number is Positive :"+request.number);
        }else {
            this.processor.process(request);
        }
    }
}
 class NegativeProcessor implements Processor{

    private Processor processor;

    public NegativeProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void process(Request request) {
        if (request.number<0){
            System.out.println("Number is Negative :"+request.number);
        }else {
            this.processor.process(request);
        }
    }
}
 class ZeroProcessor implements Processor{

    private Processor processor;

    public ZeroProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void process(Request request) {
        if (request.number==0){
            System.out.println("Number is Zero :"+request.number);
        }else {
            this.processor.process(request);
        }
    }
}
