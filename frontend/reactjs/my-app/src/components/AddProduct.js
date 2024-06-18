import React from 'react';

class AddProduct extends React.Component {

    constructor() {
        super();
        this.state = {
            pname: '',
            pprice: '',
            pdate: '',
            pcategory: ''
        }
        this.onChangeHandler = this.onChangeHandler.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChangeHandler(event) {
        // console.log(event.target.value);
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    onSubmit() {
        alert("form submitted and "+this.state.pname+" is saved");
    }

    render() {
        return (
            <div>
                <div>
                    <label>Product Name</label>
                    <input type="text" name="pname" id="pname"
                        value={this.state.pname} onChange={this.onChangeHandler} />
                </div>
                <div>
                    <label>Product Price</label>
                    <input type="text" name="pprice" id="pprice"
                        value={this.state.pprice} onChange={this.onChangeHandler} />
                </div>
                <div>
                    <label>MFD</label>
                    <input type="date" name="pdate" id="pdate"
                        value={this.state.pdate} onChange={this.onChangeHandler} />
                </div>
                <div>
                    <label>Category</label>
                    <input type="text" name="pcategory" id="pcategory"
                        value={this.state.pcategory} onChange={this.onChangeHandler} />
                </div>
                <button onClick={this.onSubmit}>Save</button>
            </div>
        )
    }
}

export default AddProduct;