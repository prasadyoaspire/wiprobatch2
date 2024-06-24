import { useSelector,useDispatch } from "react-redux";
import { increment,decrement } from "./counterSlice";


function Counter() {

    const value = useSelector(state=>state.counter.counterValue);
    const dispatch = useDispatch();

    const incrementByOne = () => {
        dispatch(increment());
    }

    const decrementByOne = () => {
        dispatch(decrement());
    }

    return (
        <div>
            <h3>Counter: {value}</h3>
            <button onClick={incrementByOne}>+</button>
            <button onClick={decrementByOne}>-</button>
        </div>
    )
}

export default Counter;