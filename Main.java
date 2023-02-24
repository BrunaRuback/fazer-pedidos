import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scanner.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("---------");
        System.out.println("Enter order data");
        System.out.print("Status (PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED): ");
        OrderStatus status = OrderStatus.valueOf(scanner.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many products to this order? ");
        int nItens = scanner.nextInt();
        for(int i = 1; i <= nItens; i++)
        {
            System.out.println("Enter #" + i + " item data");
            System.out.print("Product name: ");
            scanner.nextLine();
            String productName = scanner.nextLine();
            System.out.print("Product price: ");
            double price = scanner.nextDouble();

            Product product = new Product(productName, price);

            
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();

            OrderItem orderItem = new OrderItem(quantity, price, product); 
			order.addItem(orderItem);
            
        }

        System.out.println("---------");
        System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		scanner.close();
        
    }
}
