import { combineReducers } from "redux";
import { counterReducer } from "./counterReducer";

const rootReducer = combineReducers({
    cReducer : counterReducer
})

export default rootReducer;