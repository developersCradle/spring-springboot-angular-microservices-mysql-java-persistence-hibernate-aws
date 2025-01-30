db = db.getSiblingDB('product-service');

db.createCollection('products');

db.products.insertMany(
        [
            {
                "name" : "Admin User",
                "price" : "4000"
            }
        ],
        [
            {
                "name": "Test User",
                "price" : "3000"
            }
        ]
)