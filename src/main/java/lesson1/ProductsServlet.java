package lesson1;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductsServlet extends GenericServlet {

    private ArrayList<Product> list = new ArrayList<>();
    private HashMap<String, Integer> products = new HashMap<>();
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        createProducts();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();

        servletResponse.setContentType("text/html");
        sb.append("<h1>Product list:</h1>");
        sb.append(System.lineSeparator());
        sb.append("<ul>");

        for (Product product : list) {
            sb.append("<li>").append(product.toString()).append("</li>").toString();
        }

        sb.append("</ul>");

        servletResponse.getWriter().write(sb.toString());

    }

    private void createProducts() {
        // Fill the product list.
        products.put("Apple", 85);
        products.put("Orange", 100);
        products.put("Pineapple", 75);
        products.put("Grape", 66);
        products.put("Lemon", 54);
        products.put("Cherry", 94);
        products.put("Avocado", 92);
        products.put("Peach", 83);
        products.put("Watermelon", 65);
        products.put("Melon", 72);
        // Create products.
        for (Map.Entry product: products.entrySet()) {
            list.add(new Product(product.getKey().toString(), (int) product.getValue()));
        }
    }

}
