import React from 'react';

import axios from 'axios';
import DisplayProducts from './DisplayProducts';

class FetchAllProducts extends React.Component {

    constructor() {
        super();
        this.state = {
            products: []
        }
    }
    componentDidMount() {
        axios.get("http://localhost:8081/product/all")
            .then(resp => this.setState({
                products: resp.data
            }))
    }

    render() {
        return (
          <DisplayProducts products = {this.state.products}/>
        )
    }
}

export default FetchAllProducts;