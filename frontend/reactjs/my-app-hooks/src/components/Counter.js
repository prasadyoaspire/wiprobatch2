import { useState } from "react";
import { Link } from "react-router-dom";
import Navbar from "./Navbar";

function Counter() {

    const [counter, setCounter] = useState(0);

    const increment = () => {
        setCounter(counter + 1);
    }

    const decrement = () => {
        setCounter(counter - 1);
    }

    return (
        <>
            <Navbar/>
            <h3>Counter : {counter} </h3>
            <div>
                <button onClick={increment} className='btn btn-success'>+</button>
                &nbsp;  &nbsp;  &nbsp;
                <button onClick={decrement} className='btn btn-secondary'>-</button>
            </div>
            <div>
                <Link to='/' className='btn btn-dark'>Back To Home</Link>
            </div>
        </>
    )
}

export default Counter;