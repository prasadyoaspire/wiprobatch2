import ComponentA from "./ComponentA";

function MyComponent(props) {

    //const user = props.currentUser; 

    return(
        <>
        <h3>MyComponent</h3>
         {/* <ComponentA user = {user}/> */}
         <ComponentA/>
        </>
    )
}
export default MyComponent;