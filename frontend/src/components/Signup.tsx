import { Alert, Box, Button, TextField } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const SIGNUP_TOKEN_URL = "http://localhost:8081/api/auth/register";

const Signup = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");

    const [validEmail, setValidEmail] = useState(true);
    const [validPassword, setValidPassword] = useState(true);

    const [signupButtonClicked, setSignupButtonClicked] = useState(false);

    const [responseMsg, setResponseMsg] = useState("");

    useEffect(() => {
        setValidEmail(email.length > 0);
        setValidPassword(password.length > 0);
    }, [email, password]);

    function signup(e: any) {
        e.preventDefault();
        setSignupButtonClicked(true);
        if (!validEmail || !validPassword) return;
        const registrationDTO = {
            email: email,
            password: password,
            firstName: firstName,
            lastName: lastName,
            phoneNumber: phoneNumber,
        };
        axios.post(SIGNUP_TOKEN_URL, registrationDTO)
            .then(response => {
                setResponseMsg(response.data);
            })
            .catch(error => {
                try {
                    setResponseMsg(error.response.data);
                } catch(e) {
                    setResponseMsg("Cannot access authentication server!");
                }
            })

        setSignupButtonClicked(false);
    }

    return (
        <div>
            <h2>Please Sign up</h2>
            <form onSubmit={signup}>
                <Box>
                    <TextField
                        label="Email"
                        onChange={(e) => setEmail(e.target.value)}
                    />
                </Box>
                {!validEmail && signupButtonClicked ? (
                    <Alert variant="standard" severity="error">
                        Email is required!
                    </Alert>
                ) : (
                    <></>
                )}

                <Box>
                    <TextField
                        label="Password"
                        type="password"
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </Box>
                {!validPassword && signupButtonClicked ? (
                    <Alert variant="standard" severity="error">
                        Password is required!
                    </Alert>
                ) : (
                    <></>
                )}

                <Box>
                    <TextField
                        label="First Name"
                        onChange={(e) => setFirstName(e.target.value)}
                    />
                </Box>

                <Box>
                    <TextField
                        label="Last Name"
                        onChange={(e) => setLastName(e.target.value)}
                    />
                </Box>

                <Box>
                    <TextField
                        label="Phone number"
                        onChange={(e) => setPhoneNumber(e.target.value)}
                    />
                </Box>

                {responseMsg ? (
                    <Alert variant="standard" severity='info'>{responseMsg}</Alert>
                ) : (
                    <></>
                )}

                <Box>
                    <Button
                        type="submit"
                        variant='contained'
                    >
                        Sign up
                    </Button>
                </Box>
            </form>
            <h3>OR</h3>
            <Link to="/">
                <Button>
                    Log in
                </Button>
            </Link>
        </div>
    );
}

export default Signup