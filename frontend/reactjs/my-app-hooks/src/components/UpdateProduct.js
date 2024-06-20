import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from 'axios';

function UpdateProduct() {

    const [pid, setPid] = useState('');
    const [pname, setPname] = useState('');
    const [pprice, setPprice] = useState('');
    const [pdate, setPdate] = useState('');
    const [pcategory, setPcategory] = useState('');

    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        axios.get("http://localhost:8081/product/" + id)
            .then(resp => {
                setPid(resp.data.productId);
                setPname(resp.data.productName);
                setPprice(resp.data.productPrice);
                setPdate(resp.data.mfd);
                setPcategory(resp.data.category);
            });
    }, [id]);

    const handleUpdate = () => {
        const payload = {
            productId: pid,
            productName: pname,
            productPrice: pprice,
            mfd: pdate,
            category: pcategory
        }

        axios.put("http://localhost:8081/product/update", payload)
            .then(resp => {
                alert("Product with id :" + resp.data.productId + " is updated");
                navigate("/product/all");
            });
    }

    return (
        <div>
            <h3>Update Product</h3>
            <div>
                <label>ProductId</label>
                <input type='text' name='pid' value={pid} disabled />
            </div>
            <div>
                <label>ProductName</label>
                <input type='text' name='pname' value={pname}
                    onChange={event => setPname(event.target.value)} />
            </div>
            <div>
                <label>ProductPrice</label>
                <input type='text' name='pprice' value={pprice}
                    onChange={event => setPprice(event.target.value)} />
            </div>
            <div>
                <label>MFD</label>
                <input type='date' name='pdate' value={pdate}
                    onChange={event => setPdate(event.target.value)} />
            </div>
            <div>
                <label>Category</label>
                <input type='text' name='pcategory' value={pcategory}
                    onChange={event => setPcategory(event.target.value)} />
            </div>
            <button onClick={handleUpdate}>Modify</button>
        </div>
    )
}

export default UpdateProduct;