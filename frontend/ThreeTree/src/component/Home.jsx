import * as React from 'react';
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";


function Index() {
    return (
        <React.Fragment>
            <Typography align='center'>
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