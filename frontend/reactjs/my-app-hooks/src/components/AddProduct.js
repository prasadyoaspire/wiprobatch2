import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function AddProduct() {

    const [name, setName] = useState('');
    const [price, setPrice] = useState('');
    const [mfd, setMfd] = useState('');
    const [category, setCategory] = useState('')

    const onSubmit = () => {
        const payload = {
            productName: name,
            productPrice: price,
            mfd: mfd,
            category: category
        }
        axios.post("http://localhost:8081/product/save", payload)
            .then(resp => alert("New Product Saved!"));
    }
    return (
        <div>
            <div className='form-group'>
                <label>Name</label>
                <input type="text" name="name" value={name}
                    onChange={event => setName(event.target.value)}
                    className="form-control" />
            </div>
            <div className='form-group'>
                <label>Price</label>
                <input type="text" name="price" value={price}
                    onChange={event => setPrice(event.target.value)}
                    className="form-control" />
            </div>
            <div className='form-group'>
                <label>MFD</label>
                <input type="date" name="mfd" value={mfd}
                    onChange={event => setMfd(event.target.value)}
                    className="form-control" />
            </div>
            <div className='form-group'>
                <label>Category</label>
                <input type="text" name="category" value={category}
                    onChange={event => setCategory(event.target.value)}
                    className="form-control" />
            </div>
            <button onClick={onSubmit} className='btn btn-primary'>Save</button>
            <div>
                <Link to='/' className='btn btn-dark'>Back To Home</Link>
            </div>
        </div>
    )
}

export default AddProduct;