
import { useSelector, useDispatch } from 'react-redux';

import { incrementByOne,decrementByOne,incrementByTen } from '../store/actions/counterActions';

function Counter2() {

    //state - getting from store
    const counter = useSelector(state => state.cReducer.counterValue);
    const dispatch = useDispatch();

    //actions
    const increment = () => {
        dispatch(incrementByOne())
    }
    const decrement = () => {
        dispatch(decrementByOne())
    }
    const incrementByValue = () => {
        dispatch(incrementByTen())
    }
    
    //view
    return (
        <>
            <h3>Counter : {counter}</h3>
            <button onClick={increment}>+</button>
            <button onClick={decrement}>-</button>
            <button onClick={incrementByValue}>Increment By 10</button>
        </>
    )
}

export default Counter2;