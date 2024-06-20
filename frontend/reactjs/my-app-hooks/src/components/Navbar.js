import { Link } from "react-router-dom";

function Navbar() {
    return (
        <>
            <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
                <Link to="/" className="navbar-brand">Logo</Link>
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <Link to="/counter" className="nav-link">Counter</Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/product/all" className="nav-link">All Products</Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/product/new" className="nav-link">Add New Product</Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/login" className="nav-link">Login</Link>
                    </li>
                </ul>
            </nav>
        </>
    )
}
export default Navbar;