function ProductData(props) {
   
    return(
        <div>
            <h3>{props.myTitle}</h3>
            <p>Id: {props.myProduct.productId}</p>
            <p>Name: {props.myProduct.productName}</p>
            <p>Price: {props.myProduct.productPrice}</p>
        </div>
    )
}

export default ProductData;