import MainPage from "./MainPage.tsx";
import Login from "./Login.tsx";

const Home = (props: any) => {
    return (
        <div>
            {!props.user ? (
                <Login setUserToken={props.setUserToken} />
            ) : (
                <MainPage user={props.user} setUserToken={props.setUserToken} />
            )}
        </div>
    )
}

export default Home