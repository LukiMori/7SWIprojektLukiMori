import {Alert, Box, Button, TextField} from "@mui/material";
import {useEffect, useState} from 'react'
import {Link} from "react-router-dom";
import axios from "axios";

const LOGIN_TOKEN_URL = "http://localhost:8081/api/auth/login";

const Login = (props: any) => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const [validEmail, setValidEmail] = useState(true);
    const [validPassword, setValidPassword] = useState(true);

    const [loginButtonClicked, setLoginButtonClicked] = useState(false);

    const [loginError, setLoginError] = useState("");

    useEffect(() => {
        setValidEmail(email.length > 0);
        setValidPassword(password.length > 0);
    }, [email, password]);

    function login(e: any) {
        e.preventDefault();
        setLoginButtonClicked(true);
        if (!validEmail || !validPassword) {
            return;
        }
        const loginBody = {
            email: email,
            password: password
        }

        axios.post(LOGIN_TOKEN_URL, loginBody)
            .then(response => {
                props.setUserToken(response.data);
            })
            .catch(error => {
                try {
                    setLoginError(error.response.data);
                } catch(e) {
                    setLoginError("Cannot access authentication server!");
                }
            });

        setLoginButtonClicked(false);
    }

    return (
        <div>
            <h2>Please Log in</h2>
            <form onSubmit={login}>
                <Box>
                    <TextField label='Email' onChange={(e) => setEmail(e.target.value)}/>
                </Box>
                {!validEmail && loginButtonClicked ? (
                        <Alert variant='standard' severity="error"> Email is required!</Alert>)
                    : (<></>)}
                <Box>
                    <TextField label='Password' type='password' onChange={(e) => setPassword(e.target.value)}/>
                </Box>

                {!validPassword && loginButtonClicked ? (
                        <Alert variant='standard' severity="error">Password required</Alert>)
                    : (<></>)}

                {loginError ? (
                        <Alert variant='standard' severity="error">{loginError}</Alert>)
                    : (<></>)
                }

                <Box>
                    <Button type="submit" variant="contained">
                        Log in
                    </Button>
                </Box>
            </form>
            <h3>OR</h3>
            <Link to="/signup"> <Button>
                Sign up now
            </Button></Link>
        </div>
    )
}

export default Login