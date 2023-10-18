import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import "../SuccessfullySignedUp.css";

function SuccessfullySignedUp() {
    return (
        <div className="successfully-signed-up-container">
            <Container maxWidth="sm">
                <Typography variant="h4" gutterBottom>
                    Successfully Signed Up
                </Typography>
                <Typography variant="body1">
                    Congratulations! You have successfully signed up.
                </Typography>
            </Container>
        </div>
    );
}

export default SuccessfullySignedUp;



