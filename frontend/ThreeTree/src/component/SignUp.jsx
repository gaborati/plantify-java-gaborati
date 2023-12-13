
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import {createTheme, ThemeProvider} from '@mui/material/styles';
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
            address: data.get('address'),
            password: data.get('password')
        };

        try {
            const response = await fetch('/api/v1/auth/register', {
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
            <Typography
                component={Box}
                display="flex"
                alignItems="flex-start"
                justifyContent="flex-end"
                sx={{
                    backgroundImage: 'url("https://images.unsplash.com/photo-1603912699214-92627f304eb6?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1pYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=2825")',
                    backgroundSize: 'cover',
                    backgroundRepeat: 'no-repeat',
                    minHeight: '100vh',
                    padding: '1em'
                }}
            >
                <Container component="main" maxWidth="md">
                    <CssBaseline/>
                    <Box
                        sx={{
                            width: '100%',
                            backgroundColor: 'darkgrey',
                            marginTop: 1,
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                            borderRadius: '2em',
                            padding: '2em',
                            boxShadow: '0px 10px 20px 0px rgba(0,0,0,1)',
                        }}
                    >
                        <Avatar sx={{m: 1, color: 'black'}}>
                            <LockOutlinedIcon/>
                        </Avatar>
                        <Typography component="h1" variant="h5" >

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
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                autoComplete="current-password"
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
                                label="Phone Number"
                                name="phoneNumber"
                                type="text"
                                id="phoneNumber"
                                autoComplete="tel"
                            />
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                sx={{
                                    width: '90%', // Set the width to 50%
                                    height: '2.8em',
                                    mx: "auto",    // Center the button horizontally
                                    mt: 2,
                                    mb: 3,
                                    ml: 3.8
                                }}
                                onClick={() => {
                                    window.location.href = "/signin"
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
                </Container>
            </Typography>
        </ThemeProvider>
    );
}