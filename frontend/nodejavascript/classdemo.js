class Product {

    // constructor() {
    //     this.productId =0;
    //     this.productName = null;
    //     this.productPrice = 0;
    // }

    constructor(pid, pname, pprice) {
        this.productId =pid;
        this.productName = pname;
        this.productPrice = pprice;
    }

    display() {
        console.log("productId: "+this.productId);
        console.log("productName: "+this.productName);
        console.log("productPrice: "+this.productPrice);
    }
}

// const myProduct = new Product();
// myProduct.productId = 1001;
// myProduct.productName = "IphoneX";
// myProduct.productPrice = 50000;

// myProduct.display();


const myProduct2 = new Product(1002,"Samsung",58222);
myProduct2.display();
