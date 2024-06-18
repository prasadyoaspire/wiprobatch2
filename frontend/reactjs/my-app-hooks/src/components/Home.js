import { Link } from "react-router-dom";

function Home() {
    return (
        <div>
            <h3>Home Page</h3>
            <p><Link to="/counter">Counter</Link></p>
            <p><Link to="/product/all">Product List</Link></p>
            <p><Link to="/product/add">Add New Product</Link></p>
        </div>
    )
}

export default Home;