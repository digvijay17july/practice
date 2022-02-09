import java.util.HashMap;
import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        ItalianDishes redSaucePasta=new ItalianDishesFactory().getDish(Type.PASTA);
        redSaucePasta.sauce("RED");
        redSaucePasta.make();
        redSaucePasta.serve();
        ItalianDishes pizzaOne=new  ItalianDishesFactory().getDish(Type.PIZZA);
        pizzaOne.sauce("TOMATO");
        pizzaOne.make();
        pizzaOne.serve();

        ItalianDishes whiteSaucePasta=new ItalianDishesFactory().getDish(Type.PASTA);
        whiteSaucePasta.sauce("RED");
        whiteSaucePasta.make();
        whiteSaucePasta.serve();

        ItalianDishes pizzaTwo=new  ItalianDishesFactory().getDish(Type.PIZZA);
        pizzaTwo.sauce("CHEESE");
        pizzaTwo.make();
        pizzaTwo.serve();
        System.out.println("Red Sauce pasta Object :" + System.identityHashCode(redSaucePasta));
        System.out.println("White Sauce pasta Object :" + System.identityHashCode(whiteSaucePasta));
        System.out.println("Tomato Spread pizza Object :" + System.identityHashCode(pizzaOne));
        System.out.println("Cheese Spread pizza Object :" + System.identityHashCode(pizzaTwo));

    }

    enum Type {
        PIZZA,
        PASTA
    }

    interface ItalianDishes {
        void make();
        void sauce(String sauce);
        void serve();
    }

    static class PizzaRecipe implements ItalianDishes {
        private final String base;
        String  spread="white";

        PizzaRecipe() {
            this.base="solid";
        }

        @Override
        public void make() {
            System.out.println("Started making pizza -> PIZZA BASE : PIZZA SAUCE: SPREAD("+this.spread+") : VEGGIES :BAKE\n");
        }

        @Override
        public void sauce(String sauce) {
            this.spread=sauce;
        }

        @Override
        public void serve() {
            System.out.println("Serving pizza -> SLICE : SPREAD OREGANO : SPREAD CHILLI FLAKES : SERVE THE PIECES\n");
        }
    }

   static class PastaRecipe implements ItalianDishes {
        String  sauce="white";
       private final String base;

       PastaRecipe() {
           this.base="liquid";
       }

       @Override
        public void make() {
            System.out.println("Started making pasta -> PENNE PASTA : PASTA SAUCE : VEGGIES :BAKE\n");
        }

        @Override
        public void sauce(String sauce) {
            this.sauce=sauce;
        }

        @Override
        public void serve() {
            System.out.println("Serving pasta -> TAKE A BOWL : ADD PASTA : SPREAD OREGANO : SERVE THE BOWL\n");
        }
    }

    static class ItalianDishesFactory {
        static Map<Type,ItalianDishes> italianDishesCache = new HashMap();
        ItalianDishes getDish(Type type){
            ItalianDishes dish=italianDishesCache.get(type);
            if (dish!=null){
                return dish;
            }else {
                switch (type){
                    case PIZZA:
                        dish=new PizzaRecipe();
                        break;
                    case PASTA:
                        dish=new PastaRecipe();
                        break;
                    default :
                        System.out.println("Unreachable code!");
                }
            }
            italianDishesCache.put(type,dish);
            return dish;
        }
    }
}