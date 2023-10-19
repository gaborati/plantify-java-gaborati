import * as React from 'react';
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

function Index() {
    return (
        <React.Fragment>
            <Typography
                component={Box}
                display="flex"
                alignItems="flex-start"
                justifyContent="flex-end"
                sx={{
                    backgroundImage: `url('https://images.unsplash.com/photo-1603912699214-92627f304eb6?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=2825')`,
                    backgroundSize: 'cover',
                    backgroundRepeat: 'no-repeat',
                    minHeight: '100vh',
                    padding: '1em'
                }}
            >
                <Button
                    color='primary'
                    size='large'
                    variant='contained'
                    onClick={() => {
                        window.location.href = "/signup"
                    }}
                >
                    Sign Up
                </Button>
            </Typography>
        </React.Fragment>
    );
}

export default Index;
