import { useState } from "react";

function Counter() {

    const[counter, setCounter] = useState(0);

    const increment = () => {
        setCounter(counter+1);
    }

    const decrement = () => {
        setCounter(counter-1);
    }

    return(
        <div>
            <h3>Counter : {counter} </h3>
            <button onClick={increment}>+</button>
            <button onClick={decrement}>-</button>
        </div>
    )
}

export default Counter;