function Dashboard() {
   const isLoggedIn = false;
    return (
        <div>
            <h3>Dashboard</h3>
            {
                isLoggedIn === true ?  <button>Logout</button> : <button>LogIn</button>
            }           
        </div>
    )
}

export default Dashboard;