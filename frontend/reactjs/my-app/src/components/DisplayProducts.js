function DisplayProducts(props) {
    return(
        <div>
        <h3>All Products</h3>
        <table border={1}>
            <thead>
                <tr>
                    <th>ProductId</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>MFD</th>
                    <th>Category</th>
                </tr>
            </thead>
            <tbody>

                {
                    props.products.map(p =>
                        <tr>
                            <td>{p.productId}</td>
                            <td>{p.productName}</td>
                            <td>{p.productPrice}</td>
                            <td>{p.mfd}</td>
                            <td>{p.category}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>

    </div>
    )
}

export default DisplayProducts;