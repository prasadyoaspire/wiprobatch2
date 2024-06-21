import { useContext } from "react";
import { MyContext } from "./MyContext";


function ComponentB(props) {
   // const user = props.user;
   const loggedInUser = useContext(MyContext);
    return(
        <>
        <h3>Component B</h3>
        {/* <h3>Name : {user.name}  Role: {user.role}</h3> */}
        <h3>Name : {loggedInUser.name}  Role: {loggedInUser.role}</h3>
        </>
    )
}
export default ComponentB;