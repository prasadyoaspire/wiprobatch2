import { combineReducers } from "redux";
import { counterReducer } from "./counterReducer";
import { productReduder } from "./productReducer";

const rootReducer = combineReducers({
    cReducer : counterReducer,
    pReducer : productReduder
})

export default rootReducer;