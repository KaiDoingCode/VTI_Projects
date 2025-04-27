-- ecommerce_seed.sql

-- Part 1: Basic Data Seeding

-- Insert Roles
INSERT INTO ecommerce_db.roles (role_name) VALUES
('Admin'),
('Customer'),
('Staff');

-- Insert Brands
INSERT INTO ecommerce_db.brands (name) VALUES
('Apple'), ('Samsung'), ('Nike'), ('Adidas'), ('Sony'),
('Dell'), ('HP'), ('Asus'), ('Microsoft'), ('Google');

-- Insert Suppliers
INSERT INTO ecommerce_db.suppliers (name, contact_email) VALUES
('Global Supplies', 'contact1@example.com'),
('Tech Distributors', 'contact2@example.com'),
('Fashion Wholesale', 'contact3@example.com'),
('Gadget World', 'contact4@example.com'),
('Electronic Hub', 'contact5@example.com'),
('Lifestyle Products', 'contact6@example.com'),
('Sports Gear Ltd.', 'contact7@example.com'),
('Office Essentials', 'contact8@example.com'),
('Home Supplies Co.', 'contact9@example.com'),
('Smart Accessories', 'contact10@example.com');

-- Insert Categories
INSERT INTO ecommerce_db.categories (name) VALUES
('Electronics'),
('Clothing'),
('Books'),
('Shoes'),
('Sports'),
('Office Supplies'),
('Home & Kitchen'),
('Accessories');

-- Insert Shipping Methods
INSERT INTO ecommerce_db.shipping_methods (name, cost) VALUES
('Standard', 5.00),
('Express', 10.00),
('Pickup', 0.00),
('Same Day', 20.00),
('International', 30.00);

-- Insert Warehouses
INSERT INTO ecommerce_db.warehouses (name, location) VALUES
('Warehouse A', 'New York'),
('Warehouse B', 'Los Angeles'),
('Warehouse C', 'Chicago'),
('Warehouse D', 'Houston'),
('Warehouse E', 'Miami');


-- Part 2: Users, Customers, Admins Seeding

-- Insert Users
INSERT INTO ecommerce_db.users (username, email, password_hash) VALUES
('user001', 'user001@example.com', MD5('password')),
('user002', 'user002@example.com', MD5('password')),
('user003', 'user003@example.com', MD5('password')),
('user004', 'user004@example.com', MD5('password')),
('user005', 'user005@example.com', MD5('password')),
('user006', 'user006@example.com', MD5('password')),
('user007', 'user007@example.com', MD5('password')),
('user008', 'user008@example.com', MD5('password')),
('user009', 'user009@example.com', MD5('password')),
('user010', 'user010@example.com', MD5('password')),
('user011', 'user011@example.com', MD5('password')),
('user012', 'user012@example.com', MD5('password')),
('user013', 'user013@example.com', MD5('password')),
('user014', 'user014@example.com', MD5('password')),
('user015', 'user015@example.com', MD5('password')),
('user016', 'user016@example.com', MD5('password')),
('user017', 'user017@example.com', MD5('password')),
('user018', 'user018@example.com', MD5('password')),
('user019', 'user019@example.com', MD5('password')),
('user020', 'user020@example.com', MD5('password')),
('user021', 'user021@example.com', MD5('password')),
('user022', 'user022@example.com', MD5('password')),
('user023', 'user023@example.com', MD5('password')),
('user024', 'user024@example.com', MD5('password')),
('user025', 'user025@example.com', MD5('password')),
('user026', 'user026@example.com', MD5('password')),
('user027', 'user027@example.com', MD5('password')),
('user028', 'user028@example.com', MD5('password')),
('user029', 'user029@example.com', MD5('password')),
('user030', 'user030@example.com', MD5('password')),
('user031', 'user031@example.com', MD5('password')),
('user032', 'user032@example.com', MD5('password')),
('user033', 'user033@example.com', MD5('password')),
('user034', 'user034@example.com', MD5('password')),
('user035', 'user035@example.com', MD5('password')),
('user036', 'user036@example.com', MD5('password')),
('user037', 'user037@example.com', MD5('password')),
('user038', 'user038@example.com', MD5('password')),
('user039', 'user039@example.com', MD5('password')),
('user040', 'user040@example.com', MD5('password')),
('user041', 'user041@example.com', MD5('password')),
('user042', 'user042@example.com', MD5('password')),
('user043', 'user043@example.com', MD5('password')),
('user044', 'user044@example.com', MD5('password')),
('user045', 'user045@example.com', MD5('password')),
('user046', 'user046@example.com', MD5('password')),
('user047', 'user047@example.com', MD5('password')),
('user048', 'user048@example.com', MD5('password')),
('user049', 'user049@example.com', MD5('password')),
('user050', 'user050@example.com', MD5('password'));

-- Insert Customers (first 45 users as customers)
INSERT INTO ecommerce_db.customers (user_id, first_name, last_name, phone, address) VALUES
(1, 'John', 'Doe', '1234567890', '123 Main St'),
(2, 'Jane', 'Smith', '2345678901', '456 Oak St'),
(3, 'Alice', 'Johnson', '3456789012', '789 Pine St'),
(4, 'Bob', 'Williams', '4567890123', '101 Elm St'),
(5, 'Charlie', 'Brown', '5678901234', '202 Maple St');

-- Insert Admins (5 admins)
INSERT INTO ecommerce_db.admins (user_id) VALUES
(46), (47), (48), (49), (50);

-- Insert User Roles
INSERT INTO ecommerce_db.user_roles (user_id, role_id) VALUES
(1, 2), (2, 2), (3, 2), (4, 2), (5, 2),
(6, 2), (7, 2), (8, 2), (9, 2), (10, 2),
(11, 2), (12, 2), (13, 2), (14, 2), (15, 2),
(16, 2), (17, 2), (18, 2), (19, 2), (20, 2),
(21, 2), (22, 2), (23, 2), (24, 2), (25, 2),
(26, 2), (27, 2), (28, 2), (29, 2), (30, 2),
(31, 2), (32, 2), (33, 2), (34, 2), (35, 2),
(36, 2), (37, 2), (38, 2), (39, 2), (40, 2),
(41, 2), (42, 2), (43, 2), (44, 2), (45, 2),
(46, 1), (47, 1), (48, 1), (49, 1), (50, 1);


-- Part 3: Products, Product Categories, Inventory

-- Insert Products
INSERT INTO ecommerce_db.products (name, description, price, brand_id, supplier_id) VALUES
('iPhone 14', 'Latest Apple smartphone', 999.99, 1, 1),
('Galaxy S22', 'Flagship Samsung smartphone', 899.99, 2, 2),
('Nike Air Max', 'Popular Nike shoes', 149.99, 3, 3),
('Adidas Ultraboost', 'Best-selling Adidas running shoes', 179.99, 4, 3),
('Sony WH-1000XM4', 'Noise-canceling headphones', 349.99, 5, 4),
('Dell XPS 13', 'High-end Dell laptop', 1199.99, 6, 5),
('HP Spectre x360', 'Premium HP convertible laptop', 1299.99, 7, 5),
('Asus ROG Strix', 'Gaming laptop by Asus', 1599.99, 8, 5),
('Surface Pro 8', 'Microsoft 2-in-1 laptop', 1399.99, 9, 5),
('Pixel 6', 'Google smartphone', 799.99, 10, 2);

-- Insert Product Categories
INSERT INTO ecommerce_db.product_categories (product_id, category_id) VALUES
(1, 1), (2, 1), (3, 4), (4, 4), (5, 1),
(6, 1), (7, 1), (8, 1), (9, 1), (10, 1);

-- Insert Inventory
INSERT INTO ecommerce_db.inventory (product_id, warehouse_id, stock_quantity) VALUES
(1, 1, 100), (2, 2, 120), (3, 3, 80), (4, 3, 90), (5, 4, 50),
(6, 5, 60), (7, 1, 70), (8, 2, 40), (9, 3, 30), (10, 4, 55);


-- Part 4: Orders, Order Items, Payments, Shipments

-- Insert Orders
INSERT INTO ecommerce_db.orders (customer_id, order_date, status, total_amount) VALUES
(1, '2024-04-01', 'Completed', 1049.99),
(2, '2024-04-02', 'Processing', 179.99),
(3, '2024-04-03', 'Completed', 1299.99),
(4, '2024-04-04', 'Cancelled', 799.99),
(5, '2024-04-05', 'Completed', 349.99);

-- Insert Order Items
INSERT INTO ecommerce_db.order_items (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 999.99),
(1, 5, 1, 349.99),
(2, 3, 1, 149.99),
(2, 4, 1, 179.99),
(3, 7, 1, 1299.99),
(4, 10, 1, 799.99),
(5, 5, 1, 349.99);

-- Insert Payments
INSERT INTO ecommerce_db.payments (order_id, payment_date, amount, payment_method) VALUES
(1, '2024-04-01', 1349.98, 'Credit Card'),
(2, '2024-04-02', 329.98, 'PayPal'),
(3, '2024-04-03', 1299.99, 'Credit Card'),
(4, '2024-04-04', 799.99, 'PayPal'),
(5, '2024-04-05', 349.99, 'Credit Card');

-- Insert Shipments
INSERT INTO ecommerce_db.shipments (order_id, shipped_date, delivery_date, shipping_method_id) VALUES
(1, '2024-04-02', '2024-04-04', 1),
(2, '2024-04-03', '2024-04-06', 2),
(3, '2024-04-04', '2024-04-07', 1),
(4, '2024-04-05', NULL, 2),
(5, '2024-04-06', '2024-04-08', 3);

-- Insert Transactions
INSERT INTO ecommerce_db.transactions (payment_id, transaction_date, amount) VALUES
(1, '2024-04-01', 1349.98),
(2, '2024-04-02', 329.98),
(3, '2024-04-03', 1299.99),
(4, '2024-04-04', 799.99),
(5, '2024-04-05', 349.99);

-- Insert Wishlists
INSERT INTO ecommerce_db.wishlists (customer_id) VALUES
(1), (2), (3);

-- Insert Wishlist Items
INSERT INTO ecommerce_db.wishlist_items (wishlist_id, product_id) VALUES
(1, 1), (1, 2), (1, 3),
(2, 4), (2, 5), (2, 6),
(3, 7), (3, 8), (3, 9);

-- Insert Reviews
INSERT INTO ecommerce_db.reviews (product_id, customer_id, rating, comment) VALUES
(1, 1, 5, 'Excellent product!'),
(2, 2, 4, 'Very good.'),
(3, 3, 3, 'Average experience.'),
(4, 4, 5, 'Highly recommend.'),
(5, 5, 4, 'Good value for money.');

-- Insert Questions
INSERT INTO ecommerce_db.questions (product_id, customer_id, question_text) VALUES
(1, 1, 'Does this product support wireless charging?'),
(2, 2, 'Is this product waterproof?');

-- Corrected Insert Answers
INSERT INTO ecommerce_db.answers (question_id, admin_id, answer_text) VALUES
(1, 1, 'Yes, it supports wireless charging.'), 
(2, 2, 'No, it is not waterproof.');         

-- Insert Support Tickets
INSERT INTO ecommerce_db.support_tickets (customer_id, subject, status) VALUES
(1, 'Order not received', 'Open'),
(2, 'Payment issue', 'Resolved');

-- Insert Ticket Messages
INSERT INTO ecommerce_db.ticket_messages (ticket_id, sender_id, message) VALUES
(1, 1, 'I have not received my order yet.'),
(1, 46, 'We are checking with the courier.'),
(2, 2, 'Payment did not go through.'),
(2, 47, 'Issue has been resolved, please check.');

-- Insert Audit Logs
INSERT INTO ecommerce_db.audit_logs (user_id, action) VALUES
(1, 'Login'),
(2, 'Update Profile'),
(46, 'Create Admin Account');

-- Insert Activity Logs
INSERT INTO ecommerce_db.activity_logs (user_id, activity) VALUES
(1, 'Viewed product page'),
(2, 'Added product to wishlist'),
(46, 'Answered customer question');

-- Insert Stock Movements
INSERT INTO ecommerce_db.stock_movements (product_id, warehouse_id, quantity) VALUES
(1, 1, -2),
(2, 2, -1),
(3, 3, -1),
(4, 3, -1),
(5, 4, -1);
