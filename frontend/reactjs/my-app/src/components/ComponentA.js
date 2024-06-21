import ComponentB from "./ComponentB";

function ComponentA(props) {

   // const user = props.user;

    return (
        <>
            <h3>Component A</h3>
            {/* <ComponentB  user = {user} /> */}
            <ComponentB/>
        </>
    )
}
export default ComponentA;