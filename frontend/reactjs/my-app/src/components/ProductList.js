function ProductList() {

    const products = [
        {
            productId : 1001,
            productName : 'IphoneX',
            productPrice : 85000,
        },
        {
            productId : 1002,
            productName : 'IphoneY',
            productPrice : 85000,
        },
        {
            productId : 1003,
            productName : 'IphoneZ',
            productPrice : 95000,
        }
    ]

    return(
        <div>
            <h4>Product List</h4>
            {
                products.map(p => <div>
                    {p.productId} {p.productName} {p.productPrice}
                </div>)
            }
        </div>
    )
}
export default ProductList;