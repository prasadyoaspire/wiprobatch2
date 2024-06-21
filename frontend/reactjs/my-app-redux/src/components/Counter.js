import { useState } from 'react'

function Counter() {

    //state
    const [counterValue, setCounterValue] = useState(0);

    //actions
    const increment = () => {
        setCounterValue(counterValue+1);
    }
    const decrement = () => {
        setCounterValue(counterValue-1);
    }

    //view
    return (
        <>
            <h3>Counter : {counterValue}</h3>
            <button onClick={increment}>+</button> 
            <button onClick={decrement}>-</button>
        </>
    )
}

export default Counter;