package solid;

import java.util.List;
import java.util.stream.Stream;

/**
 *    Open closed Principle
 *   Class or method should be Open for extension closed for modification
 *
 *   @TODO NO-NOTES: A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
 *             Streams don’t change the original data structure, they only provide the result as per the pipelined methods
 *             Create: Object with .var       new Product("Mercedes", OCP.Model.C63, OCP.Color.RED).var
 *             Add multiple objects to list:  List<Product> products = List.of(mercedes, bmw, audi);
 */
public class OCP {

    enum Color{RED, GREEN, WHITE, BLACK, YELLOW;}
    enum Model{C300, E53AMG, C63, CLS, S600, G63AMG, M8, Tycan, Q8}
}

class Product{
     String make;
     OCP.Model model;
     OCP.Color color;

    public Product(String make, OCP.Model model, OCP.Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Make: " + make + " " +
                "Model: " + model + " " +
                "Color: " + color;
    }
}

/**
 * This class violates Open Closed Principle
 * Whenever we want to add new filter we have to update this class
 */
class ProductFilter{
    public Stream<Product> filterByColor(List<Product> products, OCP.Color color){
       return products.stream().filter(p -> p.color == color); }

    public Stream<Product> filterByColorAndModel(List<Product> products, OCP.Color color, OCP.Model model){
        return products.stream().filter(p -> p.color == color && p.model == model); }
}

/**
 * Better approach is using Specification pattern
 * Upside of this implementation each time we need to add new filter
 * we don't have to modify existing class
 * We can simply create new class by inheriting existing functional interfaces
 *
 * We introduce 2  functional interface that are open for extension
 */
@FunctionalInterface
interface Specification<T>{
    boolean isSatisfy(T item);
}

@FunctionalInterface
interface Filter<T>{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{
    OCP.Color color;

    public ColorSpecification(OCP.Color color) {
        this.color = color;
    }
    @Override
    public boolean isSatisfy(Product item) {
        return this.color == item.color;
    }
}

class ModelSpecification implements Specification<Product>{
    OCP.Model model;

    public ModelSpecification(OCP.Model model) {this.model = model;}

    @Override
    public boolean isSatisfy(Product item) {
        return this.model == item.model;
    }
}

class AndSpecification<T> implements Specification<T>
{
    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfy(T item) {
        return first.isSatisfy(item) && second.isSatisfy(item);
    }
}

class NewFilter implements Filter<Product>{

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfy(p));
    }
}

class Demo{
    public static void main(String[] args) {
        Product mercedes = new Product("Mercedes", OCP.Model.C63, OCP.Color.RED);
        Product bmw = new Product("BMW", OCP.Model.M8, OCP.Color.BLACK);
        Product audi = new Product("Audi", OCP.Model.Q8, OCP.Color.WHITE);

        List<Product> products = List.of(mercedes, bmw, audi);

        NewFilter productFilter = new NewFilter();
        productFilter.filter(products, new ColorSpecification(OCP.Color.RED))
                .forEach(System.out::println);


        productFilter.filter(products,
                new AndSpecification<>(
                        new ColorSpecification(OCP.Color.BLACK),
                        new ModelSpecification(OCP.Model.M8)
                ))
                .forEach(p -> System.out.println(" - " + p.make + " is Black M8"));
    }
}
