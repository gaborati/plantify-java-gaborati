import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import {createTheme, ThemeProvider} from '@mui/material/styles';

function Copyright(props) {
    return (
        <Typography variant="body2" color="text.secondary" align="center" {...props}>
            {'Copyright © '}
            <Link color="inherit" href="https://mui.com/">
                Your Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}


const defaultTheme = createTheme();

export default function SignUp() {
    const handleSubmit = async (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);

        const requestBody = {
            FirstName: data.get('First Name'),
            LastName: data.get('Last Name'),
            email: data.get('email'),
            phoneNumber: data.get('phoneNumber'),
            address: data.get('address')
        };

        try {
            const response = await fetch('/api/customers', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestBody)
            });

            if (!response.ok) {
                throw new Error("ERROR: Failed to send request to server.");
            } else {
                console.log("Successfully sent request to server.");
            }

        } catch (error) {
            console.error('Failed to send request:', error);
        }

    };

    return (
        <ThemeProvider theme={defaultTheme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline/>
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Avatar sx={{m: 1, bgcolor: 'secondary.main'}}>
                        <LockOutlinedIcon/>
                    </Avatar>
                    <Typography component="h1" variant="h5">
                        Sign up
                    </Typography>
                    <Box component="form" onSubmit={handleSubmit} noValidate sx={{mt: 1}}>
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="First Name"
                            label="First Name"
                            type="text"
                            id="firstName"
                            autoComplete="given-name"
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="Last Name"
                            label="Last Name"
                            type="text"
                            id="lastName"
                            autoComplete="family-name"
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="address"
                            label="Address"
                            type="text"
                            id="address"
                            autoComplete="address-line1"
                        />

                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            label="Email Address"
                            name="email"
                            type="text"
                            id="email"
                            autoComplete="email"
                        />

                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            label="Phone Number"
                            name="phoneNumber"
                            type="text"
                            id="phoneNumber"
                            autoComplete="tel"
                        />
                        <FormControlLabel
                            control={<Checkbox value="remember" color="primary"/>}
                            label="Remember me"
                        />
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{mt: 3, mb: 2}}
                            onClick={() => {
                                window.location.href = "/Products"
                            }}
                        >
                            Sign Up
                        </Button>
                        <Grid container>
                            <Grid item xs>
                            </Grid>
                        </Grid>
                    </Box>
                </Box>
                <Copyright sx={{mt: 8, mb: 4}}/>
            </Container>
        </ThemeProvider>
    );
}