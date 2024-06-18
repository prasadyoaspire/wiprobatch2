import { useState } from "react";
import axios from "axios";

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
            <div>
                <label>Name</label>
                <input type="text" name="name" value={name}
                    onChange={event => setName(event.target.value)} />
            </div>
            <div>
                <label>Price</label>
                <input type="text" name="price" value={price}
                    onChange={event => setPrice(event.target.value)} />
            </div>
            <div>
                <label>MFD</label>
                <input type="date" name="mfd" value={mfd}
                    onChange={event => setMfd(event.target.value)} />
            </div>
            <div>
                <label>Category</label>
                <input type="text" name="category" value={category}
                    onChange={event => setCategory(event.target.value)} />
            </div>
            <button onClick={onSubmit}>Save</button>
        </div>
    )
}

export default AddProduct;