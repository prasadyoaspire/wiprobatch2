
import { useSelector, useDispatch } from 'react-redux';

function Counter2() {

    //state - getting from store
    const counter = useSelector(state => state.counterReducer.counterValue);
    const dispatch = useDispatch();

    //actions
    const increment = () => {
        dispatch({
            type: 'IncrementByOne'
        })
    }
    const decrement = () => {
        dispatch({
            type: 'DecrementByOne'
        })
    }

    //view
    return (
        <>
            <h3>Counter : {counter}</h3>
            <button onClick={increment}>+</button>
            <button onClick={decrement}>-</button>
        </>
    )
}

export default Counter2;