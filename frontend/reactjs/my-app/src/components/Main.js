import ProductData from "./ProductData";

function Main() {
    const firstName = "Raj"
    const lastName = "Kumar";
    const product = {
        productId : 1001,
        productName : 'IphoneX',
        productPrice : 85000,
    }
    const title = "Product Details";
    return (
        <div>
            <h4>Main Component</h4>
            <p>Sum: {10+30}</p>
            <p>Full Name: {firstName} {lastName}</p>
            <ProductData myProduct = {product} myTitle = {title}/>           
        </div>
    )
}
export default Main;