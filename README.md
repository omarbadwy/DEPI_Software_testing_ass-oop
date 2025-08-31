Task: Build a Simple E-Commerce System.
Requirements:
1. Encapsulation
Create a class Product with private fields: productid, name, price, stock.
Use getters and setters to access the data.
Validate that price and stock cannot be negative.

2. Inheritance
Create a base class User with fields: userld, username, email.
Create two subclasses:
Customer (with a method placeOrder())
Admin (with a method updateProduct()

3. Polymorphism
Create a method getUserDetails() in the User class.
Override this method in Customer and Admin to show different details.
Demonstrate method overloading with different versions of placeOrder() (e.g., with productid only, or with productid + quantity).

4. Abstraction
Create an interface called Payment with methods process Payment() and validateCard().
Implement this interface in two classes:
CreditCard Payment
PayPal Payment
