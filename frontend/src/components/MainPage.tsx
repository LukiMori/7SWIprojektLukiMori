import {Button} from "@mui/material";

const MainPage = (props: any) => {

    function logout() {
        props.setUserToken("");
    }

    return (
        <div>
            Hello {props.user.username}
            <Button variant='contained' type="submit" onClick={logout}>Log out</Button>
        </div>
    );
};

export default MainPage