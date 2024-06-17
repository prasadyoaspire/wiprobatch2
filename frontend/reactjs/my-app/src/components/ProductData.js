function ProductData({myTitle,myProduct}) {
   
    return(
        <div>
            <h3>{myTitle}</h3>
            <p>Id: {myProduct.productId}</p>
            <p>Name: {myProduct.productName}</p>
            <p>Price: {myProduct.productPrice}</p>
        </div>
    )
}

export default ProductData;