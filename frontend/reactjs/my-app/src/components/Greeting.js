import GuestGreeting from "./GuestGreeting";
import UserGreeting from "./UserGreeting";

function Greeting() {

    const isLoggedIn = false;

    if (isLoggedIn) {
        const username = "Raj Kumar";
        return <UserGreeting username= {username} />
    }
    else {
        return <GuestGreeting />
    }
}

export default Greeting;